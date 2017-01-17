package com.zcbspay.platform.instead.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class SimplePayRequestBean extends SimplePayBaseBean {
	@NotEmpty(message = "param.empty.txnAmt")
	@Length(max = 12, message = "param.error.txnAmt")
	private String txnAmt;// 交易金额
	@NotEmpty(message = "param.empty.currencyCode")
	@Length(max = 3, message = "param.error.currencyCode")
	private String currencyCode;// 交易币种
	@Length(max = 128, message = "param.error.bindId")
	private String bindId;// 绑卡标识
	@Length(max = 1024, message = "param.error.encryptData")
	private String encryptData;// 加密信息域
	public String getTxnAmt() {
		return txnAmt;
	}
	public void setTxnAmt(String txnAmt) {
		this.txnAmt = txnAmt;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getBindId() {
		return bindId;
	}
	public void setBindId(String bindId) {
		this.bindId = bindId;
	}
	public String getEncryptData() {
		return encryptData;
	}
	public void setEncryptData(String encryptData) {
		this.encryptData = encryptData;
	}
}
