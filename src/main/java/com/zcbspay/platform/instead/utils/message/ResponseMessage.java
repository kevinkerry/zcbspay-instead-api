package com.zcbspay.platform.instead.utils.message;

// 响应报文基类
public class ResponseMessage extends BaseMessage {
	private String respCode; // 应答码
	private String respMsg; // 应答信息

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
}
