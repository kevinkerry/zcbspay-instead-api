package com.zcbspay.platform.instead.service;

import java.util.Map;

public interface TradeService {
	/**
	 * 交易查询
	 * @param sign
	 * @param data
	 * @param addit
	 * @return
	 */
	public Map<String, String> tradeQuery(String sign,String data,String addit);
	

}
