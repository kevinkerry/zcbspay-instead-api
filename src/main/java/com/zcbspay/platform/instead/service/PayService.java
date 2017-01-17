package com.zcbspay.platform.instead.service;

import java.util.Map;

public interface PayService {
	/**
	 * 快捷支付
	 * @param sign
	 * @param data
	 * @param addit
	 * @return
	 */
	public Map<String, String> simplePay(String sign,String data,String addit);
	
	/**
	 * 单笔代付
	 * @param sign
	 * @param data
	 * @param addit
	 * @return
	 */
	public Map<String, String> otherPay(String sign,String data,String addit);
	

}
