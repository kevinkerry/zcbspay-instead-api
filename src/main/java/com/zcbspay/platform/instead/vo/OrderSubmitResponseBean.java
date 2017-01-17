package com.zcbspay.platform.instead.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class OrderSubmitResponseBean extends OrderSubmitBaseBean{
	/**
	 * 响应码
	 */
	@NotEmpty(message = "param.empty.respCode")
	@Length(max = 2, message = "param.error.respCode")
	private String respCode;
	/**
	 * 应答信息
	 */
	@NotEmpty(message = "param.empty.respMsg")
	@Length(max = 256, message = "param.error.respMsg")
	private String respMsg;
	/**
	 * 受理订单号
	 */
	@NotEmpty(message = "param.empty.tn")
	@Length(max = 32, message = "param.error.tn")
	private String tn;
	
	
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
	public String getTn() {
		return tn;
	}
	public void setTn(String tn) {
		this.tn = tn;
	}


}
