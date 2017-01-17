package com.zcbspay.platform.instead.vo;

import org.hibernate.validator.constraints.Length;

public class OrderSubmitRequestBean extends OrderSubmitBaseBean{
	/**
	 * 保留域
	 */
	@Length(max = 1024, message = "param.error.reserved")
	private String reserved;
	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

}
