package com.zcbspay.platform.instead.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class NoticeAsynBaseBean {
	@NotEmpty(message = "param.empty.version")
	@Length(max = 6, message = "param.error.version")
	private String version; // 版本
	@NotEmpty(message = "param.empty.encoding")
	@Length(max = 2, message = "param.error.encoding")
	private String encoding; // 编码方式
	@NotEmpty(message = "param.empty.txnType")
	@Length(max = 2, message = "param.error.txnType")
	private String txnType; // 交易类型
	@NotEmpty(message = "param.empty.txnSubType")
	@Length(max = 2, message = "param.error.txnSubType")
	private String txnSubType; // 交易子类
	@NotEmpty(message = "param.empty.bizType")
	@Length(max = 6, message = "param.error.bizType")
	private String bizType; // 产品类型
	@NotEmpty(message = "param.empty.channelType")
	@Length(max = 2, message = "param.error.channelType")
	private String channelType; // 渠道类型
	@Length(max = 40, message = "param.error.merName")
	private String merName; // 商户名称
	@NotEmpty(message = "param.empty.orderId")
	@Length(max = 32, message = "param.error.orderId")
	private String orderId; // 商户订单号
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
	public String getMerName() {
		return merName;
	}
	public void setMerName(String merName) {
		this.merName = merName;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
