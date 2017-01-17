package com.zcbspay.platform.instead.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.instead.service.RsaService;
import com.zcbspay.platform.instead.service.TradeService;
import com.zcbspay.platform.instead.utils.BeanCopyUtil;
import com.zcbspay.platform.instead.utils.ValidateLocator;
import com.zcbspay.platform.instead.utils.security.AdditBean;
import com.zcbspay.platform.instead.utils.security.GateKeeper;
import com.zcbspay.platform.instead.utils.security.MixEncryptUtil;
import com.zcbspay.platform.instead.vo.TradeQueryRequestBean;
import com.zcbspay.platform.instead.vo.TradeQueryResponseBean;

import net.sf.json.JSONObject;

@Service
public class TradeServiceImpl implements TradeService  {

	@Autowired
	private RsaService rsaService;

	@Override
	public Map<String, String> tradeQuery(String sign, String data, String addit) {
		// 这里包含未加密的附加数据
		AdditBean additBean = new AdditBean(addit);
		// 解密出来的数据
		GateKeeper keeper = MixEncryptUtil.decode(data, sign, addit, rsaService.getLocalPrivateKey(additBean.getMerId()));
		// 这里是业务数据
		TradeQueryRequestBean tradeQueryRequestBean = (TradeQueryRequestBean) JSONObject
				.toBean(JSONObject.fromObject(keeper.getData().toString()), TradeQueryRequestBean.class);
		// 业务数据检查
		ValidateLocator.validateBeans(tradeQueryRequestBean);

		TradeQueryResponseBean tradeQueryResponseBean = BeanCopyUtil.copyBean(TradeQueryResponseBean.class,
				tradeQueryRequestBean);
		// TODO:业务逻辑的处理

		return MixEncryptUtil.encode(JSONObject.fromObject(tradeQueryResponseBean).toString(),
				rsaService.getMemPublicKey(additBean.getMerId()));
	}
	
	

}
