package com.zcbspay.platform.instead.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.business.pay.bean.PayBean;
import com.zcbspay.platform.business.pay.bean.ResultBean;
import com.zcbspay.platform.business.pay.service.QuickPayService;
import com.zcbspay.platform.instead.service.PayService;
import com.zcbspay.platform.instead.service.RsaService;
import com.zcbspay.platform.instead.utils.BeanCopyUtil;
import com.zcbspay.platform.instead.utils.ExceptionUtil;
import com.zcbspay.platform.instead.utils.ValidateLocator;
import com.zcbspay.platform.instead.utils.security.AdditBean;
import com.zcbspay.platform.instead.utils.security.GateKeeper;
import com.zcbspay.platform.instead.utils.security.MixEncryptUtil;
import com.zcbspay.platform.instead.vo.OtherPayRequestBean;
import com.zcbspay.platform.instead.vo.OtherPayResponseBean;
import com.zcbspay.platform.instead.vo.SimplePayRequestBean;
import com.zcbspay.platform.instead.vo.SimplePayResponseBean;

import net.sf.json.JSONObject;

@Service
public class PayServiceImpl implements PayService {
	@Autowired
	private RsaService rsaService;
	
	@Autowired
	private QuickPayService quickPayService;

	private static final Logger logger = LoggerFactory.getLogger(PayServiceImpl.class);
	@Override
	public Map<String, String> simplePay(String sign, String data, String addit) {
		// 这里包含未加密的附加数据
		AdditBean additBean = new AdditBean(addit);
		// 解密出来的数据
		GateKeeper keeper = MixEncryptUtil.decode(data, sign, addit, rsaService.getLocalPrivateKey(additBean.getMerId()));
		// 这里是业务数据
		SimplePayRequestBean simplePayRequestBean = (SimplePayRequestBean) JSONObject
				.toBean(JSONObject.fromObject(keeper.getData().toString()), SimplePayRequestBean.class);
		// 业务数据检查
		ValidateLocator.validateBeans(simplePayRequestBean);

		
		
		SimplePayResponseBean simplePayResponseBean = BeanCopyUtil.copyBean(SimplePayResponseBean.class,
				simplePayRequestBean);
		PayBean payBean=BeanCopyUtil.copyBean(PayBean.class,
				simplePayRequestBean);
		payBean.setCardNo("6228480018543668979");
		payBean.setCardKeeper("郭佳");
		payBean.setCardType("1");
		payBean.setPhone("18600806796");
		payBean.setCertNo("110105198610094112");
		payBean.setTn("170116061000000016");
		payBean.setTxnAmt("2");
		String respCode="";
		String respMsg="";
		try {
			ResultBean resultBean=quickPayService.pay(payBean);
			if (!resultBean.isResultBool()) {
				respCode="40";
				respMsg=resultBean.getErrMsg();
			}else{
				respCode="00";
				respMsg="订单生成成功";
			}
		} catch (Exception e) {
			respCode="40";
			respMsg=ExceptionUtil.getStackTrace(e);
			logger.error(ExceptionUtil.getStackTrace(e));
		}
		
		simplePayResponseBean.setRespCode(respCode);
		simplePayResponseBean.setRespMsg(respMsg);
		
		// TODO:业务逻辑的处理
		return MixEncryptUtil.encode(JSONObject.fromObject(simplePayResponseBean).toString(),
				rsaService.getMemPublicKey(additBean.getMerId()));
	}

	@Override
	public Map<String, String> otherPay(String sign, String data, String addit) {
		// 这里包含未加密的附加数据
		AdditBean additBean = new AdditBean(addit);
		// 解密出来的数据
		GateKeeper keeper = MixEncryptUtil.decode(data, sign, addit, rsaService.getLocalPrivateKey(additBean.getMerId()));
		// 这里是业务数据
		OtherPayRequestBean otherPayRequestBean = (OtherPayRequestBean) JSONObject
				.toBean(JSONObject.fromObject(keeper.getData().toString()), OtherPayRequestBean.class);
		// 业务数据检查
		ValidateLocator.validateBeans(otherPayRequestBean);

		OtherPayResponseBean otherPayResponseBean = BeanCopyUtil.copyBean(OtherPayResponseBean.class,
				otherPayRequestBean);
		// TODO:业务逻辑的处理

		return MixEncryptUtil.encode(JSONObject.fromObject(otherPayResponseBean).toString(),
				rsaService.getMemPublicKey(additBean.getMerId()));
	}

}
