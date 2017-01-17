package com.zcbspay.platform.instead.utils.security;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.zcbspay.platform.instead.utils.StringUtil;

import net.sf.json.JSONObject;

public class MixEncryptUtil {
	public static final String COOP_INSTI_CODE = "300000000000004"; // test
	public static final String MER_ID = "200000000000610";

	/**
	 * 加密
	 * @param data
	 * @param publicKey
	 * @return
	 */
	public static Map<String, String> encode(String data,String publicKey){
		JSONObject addit = new JSONObject();
		String key = null;
		try {
			key = AESUtil.getAESKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 组织机构的场合
		addit.put("accessType", "0");
		addit.put("coopInstiId", COOP_INSTI_CODE);
		addit.put("merId", MER_ID);

		RSAHelper rsa = null;
		rsa=new RSAHelper(publicKey, "");

		addit.put("encryKey", rsa.encrypt(key));
		addit.put("encryMethod", "02");
		Map<String, Object> riskInfo = new TreeMap<String, Object>();
		riskInfo.put("random", key);
		riskInfo.put("os", "browser");
		riskInfo.put("deviceID", "000000");
		addit.put("riskInfo", JSONObject.fromObject(riskInfo)); 

		// 签名
		String signData = Md5Utils.md5(key + addit.toString() + data, "UTF-8").toUpperCase();
		Map<String, String> post=new HashMap<>();
		Map<String, Object> signMap = new TreeMap<String, Object>();
		signMap.put("signature", signData);
		signMap.put("signMethod", "02");
		String signStr = JSONObject.fromObject(signMap).toString();
		post.put("sign", signStr);
		// 附加数据
		try {
			addit.put("riskInfo", Base64Utils.encode(AESUtil.encrypt(addit.getString("riskInfo"), key)));
			data = Base64Utils.encode(AESUtil.encrypt(data, key));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String additStr = addit.toString();
		post.put("addit", additStr);
		// 业务数据
		post.put("data", data);
		
		return post;
	}
	
	/**
	 * 解密
	 * @param data
	 * @param sign
	 * @param addit
	 * @param privateKey 私钥
	 * @return
	 */
	public static GateKeeper  decode(String data,String sign ,String addit,String privateKey){
		if (StringUtil.isEmpty(data) || StringUtil.isEmpty(sign) || StringUtil.isEmpty(addit)) {
			System.out.println("缺少数据");
		}

		RSAHelper rsa = null;
		rsa = new RSAHelper("", privateKey);
		// 守门员
		GateKeeper keeper = new GateKeeper(data, sign, addit, rsa);
		return keeper;
	}
}
