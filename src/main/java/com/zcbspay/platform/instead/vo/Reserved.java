package com.zcbspay.platform.instead.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 保留域
 * 
 * @author 123321
 *
 */
public class Reserved {
	@NotEmpty(message = "param.empty.merId")
	@Length(max = 15, message = "param.error.merId")
	private String merId;// 商户代码
	@Length(max = 40, message = "param.error.merName")
	private String merName;// 商户全称
	@Length(max = 16, message = "param.error.merAbbr")
	private String merAbbr;// 商户简称
	@NotEmpty(message = "param.empty.orderId")
	@Length(max = 32, message = "param.error.orderId")
	private String orderId;// 商户订单号
	@NotEmpty(message = "param.empty.orderType")
	@Length(max = 4, message = "param.error.orderType")
	private String orderType;// 订单类型
	@NotEmpty(message = "param.empty.txnTime")
	@Length(max = 14, message = "param.error.txnTime")
	private String txnTime;// 订单发送时间
	@NotEmpty(message = "param.empty.txnAmt")
	@Length(max = 12, message = "param.error.txnAmt")
	private String txnAmt;// 交易金额
	@NotEmpty(message = "param.empty.currencyCode")
	@Length(max = 3, message = "param.error.currencyCode")
	private String currencyCode;// 交易币种
	@Length(max = 256, message = "param.error.orderDesc")
	private String orderDesc;// 订单描述
	@NotEmpty(message = "param.empty.orderStatus")
	@Length(max = 2, message = "param.error.orderStatus")
	private String orderStatus;// 订单状态
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getMerName() {
		return merName;
	}
	public void setMerName(String merName) {
		this.merName = merName;
	}
	public String getMerAbbr() {
		return merAbbr;
	}
	public void setMerAbbr(String merAbbr) {
		this.merAbbr = merAbbr;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getTxnTime() {
		return txnTime;
	}
	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
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
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
