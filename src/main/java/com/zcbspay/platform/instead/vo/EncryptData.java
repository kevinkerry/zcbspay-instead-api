package com.zcbspay.platform.instead.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class EncryptData {
	@NotEmpty(message = "param.empty.cardNo")
	@Length(max = 20, message = "param.error.cardNo")
	private String cardNo;// 银行卡号
	@NotEmpty(message = "param.empty.cardType")
	@Length(max = 1, message = "param.error.cardType")
	private String cardType;// 卡类型
	@NotEmpty(message = "param.empty.customerNm")
	@Length(max = 30, message = "param.error.customerNm")
	private String customerNm;// 持卡人姓名
	@NotEmpty(message = "param.empty.certifTp")
	@Length(max = 2, message = "param.error.certifTp")
	private String certifTp;// 证件类型
	@NotEmpty(message = "param.empty.certifId")
	@Length(max = 20, message = "param.error.certifId")
	private String certifId;// 证件号
	@NotEmpty(message = "param.empty.phoneNo")
	@Length(max = 20, message = "param.error.phoneNo")
	private String phoneNo;// 手机号
	@NotEmpty(message = "param.empty.cvn2")
	@Length(max = 3, message = "param.error.cvn2")
	private String cvn2;// cvn2
	@NotEmpty(message = "param.empty.expired")
	@Length(max = 4, message = "param.error.expired")
	private String expired;// 卡有效期
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCustomerNm() {
		return customerNm;
	}
	public void setCustomerNm(String customerNm) {
		this.customerNm = customerNm;
	}
	public String getCertifTp() {
		return certifTp;
	}
	public void setCertifTp(String certifTp) {
		this.certifTp = certifTp;
	}
	public String getCertifId() {
		return certifId;
	}
	public void setCertifId(String certifId) {
		this.certifId = certifId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCvn2() {
		return cvn2;
	}
	public void setCvn2(String cvn2) {
		this.cvn2 = cvn2;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
}
