package com.zcbspay.platform.instead.service;

import java.util.Map;

public interface OrderService {
	/**
	 * 订单提交
	 * @param sign
	 * @param data
	 * @param addit
	 * @return
	 */
	public Map<String, String> orderSubmit(String sign,String data,String addit);
}
