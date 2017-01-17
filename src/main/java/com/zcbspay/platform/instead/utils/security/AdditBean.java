package com.zcbspay.platform.instead.utils.security;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import net.sf.json.JSONObject;

public class AdditBean {
	@NotEmpty(message = "param.empty.tn")
	@Length(max = 18, message = "param.error.tn")
	private String accessType;// 接入类型
	@NotEmpty(message = "param.empty.tn")
	@Length(max = 18, message = "param.error.tn")
	private String coopInstiId;// 合作机构号
	@NotEmpty(message = "param.empty.tn")
	@Length(max = 18, message = "param.error.tn")
	private String merId;// 商户号
	@NotEmpty(message = "param.empty.tn")
	@Length(max = 18, message = "param.error.tn")
	private String encryKey;// 加密KEY
	@NotEmpty(message = "param.empty.tn")
	@Length(max = 18, message = "param.error.tn")
	private String encryMethod;// 加密方法
	@NotEmpty(message = "param.empty.tn")
	@Length(max = 18, message = "param.error.tn")
	private String riskInfo;// 风控信息
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	public String getCoopInstiId() {
		return coopInstiId;
	}
	public void setCoopInstiId(String coopInstiId) {
		this.coopInstiId = coopInstiId;
	}
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getEncryKey() {
		return encryKey;
	}
	public void setEncryKey(String encryKey) {
		this.encryKey = encryKey;
	}
	public String getEncryMethod() {
		return encryMethod;
	}
	public void setEncryMethod(String encryMethod) {
		this.encryMethod = encryMethod;
	}
	public String getRiskInfo() {
		return riskInfo;
	}
	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}

	public AdditBean(String addit){
		JSONObject jsonAddit = JSONObject.fromObject(addit);
		setAccessType(String.valueOf(jsonAddit.getInt("accessType")));
		setCoopInstiId((String) jsonAddit.get("coopInstiId"));
		setMerId((String) jsonAddit.get("merId"));
		setEncryMethod((String) jsonAddit.get("encryMethod"));
		setEncryKey((String) jsonAddit.get("encryKey"));
		setRiskInfo(jsonAddit.get("riskInfo").toString());
		
	}
	
	
}
