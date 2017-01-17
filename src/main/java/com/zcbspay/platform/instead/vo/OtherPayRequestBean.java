package com.zcbspay.platform.instead.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class OtherPayRequestBean extends OtherPayBaseBean {
	@NotEmpty(message = "param.empty.merId")
	@Length(max = 15, message = "param.error.merId")
	private String merId;// 商户代码
	@NotEmpty(message = "param.empty.orderId")
	@Length(max = 32, message = "param.error.orderId")
	private String orderId;// 商户订单号
	@NotEmpty(message = "param.empty.currencyCode")
	@Length(max = 3, message = "param.error.currencyCode")
	private String currencyCode;// 交易币种
	@NotEmpty(message = "param.empty.txnAmt")
	@Length(max = 12, message = "param.error.txnAmt")
	private String txnAmt;// 金额
	@NotEmpty(message = "param.empty.accType")
	@Length(max = 2, message = "param.error.accType")
	private String accType;// 账号类型
	@NotEmpty(message = "param.empty.accNo")
	@Length(max = 60, message = "param.error.accNo")
	private String accNo;// 账号
	@NotEmpty(message = "param.empty.accName")
	@Length(max = 32, message = "param.error.accName")
	private String accName;// 户名
	@NotEmpty(message = "param.empty.bankCode")
	@Length(max = 11, message = "param.error.bankCode")
	private String bankCode;// 开户行代码
	@Length(max = 20, message = "param.error.issInsProvince")
	private String issInsProvince;// 开户行省
	@Length(max = 20, message = "param.error.issInsCity")
	private String issInsCity;// 开户行市
	@Length(max = 40, message = "param.error.issInsName")
	private String issInsName;// 开户行名称
	@NotEmpty(message = "param.empty.certifTp")
	private String certifTp;// 证件类型
	@NotEmpty(message = "param.empty.certifId")
	@Length(max = 20, message = "param.error.certifId")
	private String certifId;// 证件号码
	@NotEmpty(message = "param.empty.phoneNo")
	@Length(max = 20, message = "param.error.phoneNo")
	private String phoneNo;// 手机号
	@NotEmpty(message = "param.empty.billType")
	@Length(max = 4, message = "param.error.billType")
	private String billType;// 账单类型
	@NotEmpty(message = "param.empty.notes")
	@Length(max = 100, message = "param.error.notes")
	private String notes;// 附言
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getTxnAmt() {
		return txnAmt;
	}
	public void setTxnAmt(String txnAmt) {
		this.txnAmt = txnAmt;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getIssInsProvince() {
		return issInsProvince;
	}
	public void setIssInsProvince(String issInsProvince) {
		this.issInsProvince = issInsProvince;
	}
	public String getIssInsCity() {
		return issInsCity;
	}
	public void setIssInsCity(String issInsCity) {
		this.issInsCity = issInsCity;
	}
	public String getIssInsName() {
		return issInsName;
	}
	public void setIssInsName(String issInsName) {
		this.issInsName = issInsName;
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
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

}
