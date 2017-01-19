package com.zcbspay.platform.instead.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.business.exception.BusinessOrderException;
import com.zcbspay.platform.business.order.bean.OrderBean;
import com.zcbspay.platform.business.order.bean.ResultBean;
import com.zcbspay.platform.instead.service.OrderService;
import com.zcbspay.platform.instead.service.RsaService;
import com.zcbspay.platform.instead.utils.BeanCopyUtil;
import com.zcbspay.platform.instead.utils.DateUtils;
import com.zcbspay.platform.instead.utils.ExceptionUtil;
import com.zcbspay.platform.instead.utils.ValidateLocator;
import com.zcbspay.platform.instead.utils.security.AdditBean;
import com.zcbspay.platform.instead.utils.security.GateKeeper;
import com.zcbspay.platform.instead.utils.security.MixEncryptUtil;
import com.zcbspay.platform.instead.vo.OrderSubmitRequestBean;
import com.zcbspay.platform.instead.vo.OrderSubmitResponseBean;

import net.sf.json.JSONObject;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private RsaService rsaService;
	
	@Autowired
	private com.zcbspay.platform.business.order.service.OrderService remoteOrderService;

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Override
	public Map<String, String> orderSubmit(String sign, String data, String addit) {
		//这里包含未加密的附加数据
		AdditBean additBean=new AdditBean(addit);
		//解密出来的数据
		GateKeeper keeper = MixEncryptUtil.decode(data, sign, addit,rsaService.getLocalPrivateKey(additBean.getMerId()));
		
		OrderSubmitRequestBean osb=(OrderSubmitRequestBean) JSONObject.toBean(JSONObject.fromObject(keeper.getData().toString()),OrderSubmitRequestBean.class);
		ValidateLocator.validateBeans(osb);
		OrderBean oBean=BeanCopyUtil.copyBean(OrderBean.class,osb);
		oBean.setAccessType(additBean.getAccessType());
		oBean.setCoopInstiId(additBean.getCoopInstiId());
		oBean.setMerId(additBean.getMerId());
		oBean.setTxnTime(DateUtils.getCurrentDateTime());
		oBean.setOrderTimeout("28880202000000");//过期是时间是如何设置的？
		oBean.setOrderId(System.currentTimeMillis()+"");
		
		oBean.setMemberId("999999999999999");//这个参数不知道如何来
		
		OrderSubmitResponseBean osrb=BeanCopyUtil.copyBean(OrderSubmitResponseBean.class, osb);
		String respCode="";
		String respMsg="";
		
		//TODO:业务逻辑的处理
		try {
			ResultBean resultBean=remoteOrderService.createConsumeOrder(oBean);
			if (!resultBean.isResultBool()) {
				respCode="40";
				respMsg=resultBean.getErrMsg();
			}else{
				respCode="00";
				respMsg="订单生成成功";
				System.out.println("订单号："+resultBean.getResultObj().toString());
				osrb.setTn(resultBean.getResultObj().toString());
			}
		} catch (BusinessOrderException e) {
			respCode="40";
			respMsg=ExceptionUtil.getStackTrace(e);
			logger.error(ExceptionUtil.getStackTrace(e));
		}
		osrb.setRespCode(respCode);
		osrb.setRespMsg(respMsg);
		return MixEncryptUtil.encode(JSONObject.fromObject(osrb).toString(),rsaService.getMemPublicKey(additBean.getMerId()));
	}

}
