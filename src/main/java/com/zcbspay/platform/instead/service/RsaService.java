package com.zcbspay.platform.instead.service;

public interface RsaService {
	/**
	 * 获取商户私钥
	 * @param value
	 * @return
	 */
	public String getMemPrivateKey(String value);
	/**
	 * 获取商户公钥
	 * @param value
	 * @return
	 */
	public String getMemPublicKey(String value);
	/**
	 * 获取系统私钥
	 * @param value
	 * @return
	 */
	public String getLocalPrivateKey(String value);
	/**
	 * 获取系统公钥
	 * @param value
	 * @return
	 */
	public String getLocalPublicKey(String value);

}
