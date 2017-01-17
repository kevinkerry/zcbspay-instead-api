package com.zcbspay.platform.instead.utils.message;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.zcbspay.platform.instead.utils.validator.N;

// 响应基类
public class BaseMessage implements Serializable{

	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7554538268683124107L;
    protected String version; // 版本
	@Length(max = 2)
	protected String encoding; // 编码方式
	@N(max = 2, isNull = false)
	private String txnType; // 交易类型
	@N(max = 2, isNull = false)
	private String txnSubType; // 交易子类
	@N(max = 6, isNull = false)
	private String bizType; // 产品类型
	@N(min = 2, max = 2)
	private String channelType; // 渠道类型

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

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
}
