package com.zcbspay.platform.instead.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.instead.service.NoticeService;
import com.zcbspay.platform.instead.service.RsaService;
import com.zcbspay.platform.instead.utils.BeanCopyUtil;
import com.zcbspay.platform.instead.utils.ValidateLocator;
import com.zcbspay.platform.instead.utils.security.AdditBean;
import com.zcbspay.platform.instead.utils.security.GateKeeper;
import com.zcbspay.platform.instead.utils.security.MixEncryptUtil;
import com.zcbspay.platform.instead.vo.NoticeAsynRequestBean;
import com.zcbspay.platform.instead.vo.NoticeAsynResponseBean;

import net.sf.json.JSONObject;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private RsaService rsaService;
	
	@Override
	public Map<String, String> noticeasyn(String sign, String data, String addit) {
		// 这里包含未加密的附加数据
		AdditBean additBean = new AdditBean(addit);
		// 解密出来的数据
		GateKeeper keeper = MixEncryptUtil.decode(data, sign, addit,rsaService.getLocalPrivateKey(additBean.getMerId()));
		
		//这里是业务数据
		NoticeAsynRequestBean noticeAsynRequestBean = (NoticeAsynRequestBean) JSONObject
				.toBean(JSONObject.fromObject(keeper.getData().toString()), NoticeAsynRequestBean.class);
		
		//业务数据检查
		ValidateLocator.validateBeans(noticeAsynRequestBean);

		NoticeAsynResponseBean noticeAsynResponseBean = BeanCopyUtil.copyBean(NoticeAsynResponseBean.class, noticeAsynRequestBean);
		// TODO:业务逻辑的处理
		
		return MixEncryptUtil.encode(JSONObject.fromObject(noticeAsynResponseBean).toString(),rsaService.getMemPublicKey(additBean.getMerId()));
	}

}
