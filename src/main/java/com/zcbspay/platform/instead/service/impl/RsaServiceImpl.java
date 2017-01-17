package com.zcbspay.platform.instead.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.business.merch.bean.MerchMkBean;
import com.zcbspay.platform.business.merch.service.QueryMerchMkService;
import com.zcbspay.platform.instead.service.RsaService;
import com.zcbspay.platform.instead.utils.StringUtil;

@Service
public class RsaServiceImpl implements RsaService {

	private String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK1S2QvTQfbbZsGc"
			+ "B2sRS9DI0L8qNXxTdNUNT1cYTquf4eVJXVNVoq9k98dPdDOso7KmAGmbpa+I8SJz"
			+ "8CdpGBkL5ET0ggppsNIMbDNEW9tBwqbqjCW50jhA9osIUVidejtqzXDLiNiBMW0r"
			+ "WD5vlziwBdUfJV8FwnACeZ9KEOoLAgMBAAECgYBp3bbRMEKUY8LJ82Hclf33ExHe"
			+ "EgwFWnx8Pdr+WcyDq+6wvDUS17W86DEoPnG9tm9uiVKrLvTu2PhgkOxZRin+8REk"
			+ "vIe5hks1T+BnOr0zvfOmSsYASOoa2MhwcYxhc9IhV56hLUXPGJrVNatfrvV3k/Ev"
			+ "jdY3BOoYTlmCMr8QcQJBANb/4zXkAgtXiHu4rbEZ6M4H7rehDsmfXhc0hqdO8iKA"
			+ "Q/uXcFVGUEZxX8KB41LLrOWFRlxkDsU7E6dXTvuYzdcCQQDOYF+PPRtMWRXSM+eh"
			+ "yOVFRAXil7pN5g9kIATNFUJ/6ovyCApwaIr6DokW7IAP1MBwq5Z6yPTolmuJDYNT"
			+ "aTbtAkAF5gNPyS+dLAuciVaKk1FlxaXw98Q2F98298Px9yKBe89hqaf1TvaI2Ddu"
			+ "WK3p6ZiWu29QvZYCJzrEzopmMK0FAkBK/yq62vH4pMcRRFuAp4jpyvZ4ibriZCBj"
			+ "ul8ESB2Kbqm8or9oahVXGcEn23oORrpIN5LPvAeEHmWlwItg3HNhAkEAp396Y4+4"
			+ "ZOyyUJnuBgM5JQ6jCoRlym33aJYf10PpecHVLHKh4DM7EjKOopaP82wDy9ozrUT5" + "CWVLGiu8jQjPGg==";
	private String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCtUtkL00H222bBnAdrEUvQyNC/"
			+ "KjV8U3TVDU9XGE6rn+HlSV1TVaKvZPfHT3QzrKOypgBpm6WviPEic/AnaRgZC+RE"
			+ "9IIKabDSDGwzRFvbQcKm6owludI4QPaLCFFYnXo7as1wy4jYgTFtK1g+b5c4sAXV" + "HyVfBcJwAnmfShDqCwIDAQAB";
	@Autowired
	private QueryMerchMkService queryMerchMkService;

	@Override
	public String getLocalPrivateKey(String value) {
		if (StringUtil.isEmpty(value)) {
			return privateKey;
		}
		MerchMkBean merchMKBean = null;
		try {
			merchMKBean = queryMerchMkService.queryMerchMkByMemberId(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchMKBean.getLocalPriKey();
	}

	@Override
	public String getMemPublicKey(String value) {
		if (StringUtil.isEmpty(value)) {
			return publicKey;
		}
		MerchMkBean merchMKBean = null;
		try {
			merchMKBean = queryMerchMkService.queryMerchMkByMemberId(value);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchMKBean.getMemberPubKey();
	}

	@Override
	public String getMemPrivateKey(String value) {
		if (StringUtil.isEmpty(value)) {
			return privateKey;
		}
		MerchMkBean merchMKBean = null;
		try {
			merchMKBean = queryMerchMkService.queryMerchMkByMemberId(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchMKBean.getMemberPriKey();
	}

	@Override
	public String getLocalPublicKey(String value) {
		if (StringUtil.isEmpty(value)) {
			return publicKey;
		}
		MerchMkBean merchMKBean = null;
		try {
			merchMKBean = queryMerchMkService.queryMerchMkByMemberId(value);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchMKBean.getLocalPubKey();
	}

}
