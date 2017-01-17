package com.zcbspay.platform.instead.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class NoticeAsynRequestBean extends NoticeAsynBaseBean {
	@NotEmpty(message = "param.empty.txnTime")
	@Length(max = 14, message = "param.error.txnTime")
	private String txnTime; // 订单发送时间
	@NotEmpty(message = "param.empty.payTimeout")
	@Length(max = 14, message = "param.error.payTimeout")
	private String payTimeout; // 支付超时时间
	@NotEmpty(message = "param.empty.txnAmt")
	@Length(max = 12, message = "param.error.txnAmt")
	private String txnAmt; // 交易金额
	@NotEmpty(message = "param.empty.currencyCode")
	@Length(max = 3, message = "param.error.currencyCode")
	private String currencyCode; // 交易币种
	@Length(max = 256, message = "param.error.orderDesc")
	private String orderDesc; // 订单描述
	@Length(max = 1024, message = "param.error.reserved")
	private String reserved; // 保留域
	@NotEmpty(message = "param.empty.orderStatus")
	@Length(max = 2, message = "param.error.orderStatus")
	private String orderStatus; // 订单状态
	@NotEmpty(message = "param.empty.tn")
	@Length(max = 32, message = "param.error.tn")
	private String tn; // 受理订单号
	public String getTxnTime() {
		return txnTime;
	}
	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}
	public String getPayTimeout() {
		return payTimeout;
	}
	public void setPayTimeout(String payTimeout) {
		this.payTimeout = payTimeout;
	}
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
	public String getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getTn() {
		return tn;
	}
	public void setTn(String tn) {
		this.tn = tn;
	}
}
