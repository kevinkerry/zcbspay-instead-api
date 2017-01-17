package com.zcbspay.platform.instead.service;

import java.util.Map;

public interface NoticeService {
	/**
	 * 异步通知
	 * @param sign
	 * @param data
	 * @param addit
	 * @return
	 */
	public Map<String, String> noticeasyn(String sign,String data,String addit);
	

}
