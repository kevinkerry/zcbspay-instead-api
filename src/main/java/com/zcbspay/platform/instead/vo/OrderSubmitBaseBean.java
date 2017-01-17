package com.zcbspay.platform.instead.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class OrderSubmitBaseBean {
	/**
	 * 版本
	 */
	@NotEmpty(message = "param.empty.version")
	@Length(max = 6, message = "param.error.version")
	private String version;
	/**
	 * 编码方式
	 */
	@NotEmpty(message = "param.empty.encoding")
	@Length(max = 2, message = "param.error.encoding")
	private String encoding;
	/**
	 * 交易类型
	 */
	@NotEmpty(message = "param.empty.txnType")
	@Length(max = 2, message = "param.error.txnType")
	private String txnType;
	/**
	 * 交易子类
	 */
	@NotEmpty(message = "param.empty.txnSubType")
	@Length(max = 2, message = "param.error.txnSubType")
	private String txnSubType;
	/**
	 * 产品类型
	 */
	@NotEmpty(message = "param.empty.bizType")
	@Length(max = 6, message = "param.error.bizType")
	private String bizType;
	/**
	 * 渠道类型
	 */
	@NotEmpty(message = "param.empty.channelType")
	@Length(max = 2, message = "param.error.channelType")
	private String channelType;
	/**
	 * 通知地址
	 */
	@NotEmpty(message = "param.empty.backUrl")
	@Length(max = 128, message = "param.error.backUrl")
	private String backUrl;
	/**
	 * 商户全称
	 */
	@Length(max = 40, message = "param.error.merAbbr")
	private String merName;
	/**
	 * 商户简称
	 */
	@Length(max = 40, message = "param.error.merAbbr")
	private String merAbbr;
	/**
	 * 商户订单号
	 */
	@NotEmpty(message = "param.empty.orderId")
	@Length(max = 32, message = "param.error.orderId")
	private String orderId;
	/**
	 * 订单类型
	 */
	@NotEmpty(message = "param.empty.orderType")
	@Length(max = 4, message = "param.error.orderType")
	private String orderType;
	/**
	 * 订单发送时间
	 */
	@NotEmpty(message = "param.empty.txnTime")
	@Length(max = 14, message = "param.error.txnTime")
	private String txnTime;
	/**
	 * 支付超时时间
	 */
	@NotEmpty(message = "param.empty.payTimeout")
	@Length(max = 14, message = "param.error.payTimeout")
	private String payTimeout;
	/**
	 * 交易金额(单位:分)
	 */
	@NotEmpty(message = "param.empty.txnAmt")
	@Length(max = 12, message = "param.error.txnAmt")
	private String txnAmt;
	/**
	 * 交易币种
	 */
	@NotEmpty(message = "param.empty.currencyCode")
	@Length(max = 3, message = "param.error.currencyCode")
	private String currencyCode;
	/**
	 * 订单描述
	 */
	@Length(max = 256, message = "param.error.reserved")
	private String orderDesc;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getTxnSubType() {
		return txnSubType;
	}

	public void setTxnSubType(String txnSubType) {
		this.txnSubType = txnSubType;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
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

}
