package com.zcbspay.platform.instead.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class TradeQueryResponseBean extends TradeQueryBaseBean{
	@NotEmpty(message = "param.empty.respCode")
	@Length(max = 2, message = "param.error.respCode")
	private String respCode;// 响应码
	@NotEmpty(message = "param.empty.respMsg")
	@Length(max = 256, message = "param.error.respMsg")
	private String respMsg;// 应答信息
	private String reserved;// 保留域
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
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

}
