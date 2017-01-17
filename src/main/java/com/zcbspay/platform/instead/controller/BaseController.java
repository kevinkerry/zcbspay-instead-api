package com.zcbspay.platform.instead.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(BaseController.class);
	protected static final String STATUS = "status";
	protected static final String WARN = "warn";
	protected static final String SUCCESS = "success";
	protected static final String ERROR = "error";
	protected static final String MESSAGE = "message";
    
    /**
     * @author zhsd
     * @description 获取当前用户
     * @param request
     * @return Users
     */
    public Object getCurUser(HttpServletRequest request){
    	HttpSession session = getSession(request);
    	if(session != null){
    		Object obj = session.getAttribute("user");
    		if(obj != null){
    			return obj;
    		}
    	}
    	return null;
    }
    
    /**
     * @author zhsd
     * @description 获取当前用户ID
     * @param request
     * @return int
     */
    public int getCurUserId(HttpServletRequest request){
    	HttpSession session = getSession(request);
    	if(session != null){
    		Object obj = session.getAttribute("");
    		if(obj != null){
    			return (int)obj;
    		}
    	}
    	return -1;
    }
    
    /**
     * @author zhsd
     * @description 获取当前用户名
     * @param request
     * @return String
     */
    public String getCurUserName(HttpServletRequest request){
    	HttpSession session = getSession(request);
    	if(session != null){
    		Object obj = session.getAttribute("");
    		if(obj != null){
    			return obj.toString();
    		}
    	}
    	return "";
    }
    
    /**
     * @author zhsd
     * @description 获取session
     * @param request
     * @return HttpSession
     */
    public HttpSession getSession(HttpServletRequest request){
    	return request.getSession();
    }
      

	/**
	 * @author zhsd
	 * @description 输出JSON警告消息
	 * @param message
	 * @return Map
	 */
	public Map<String, Object> ajaxJsonWarnMessage(String message) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(STATUS, WARN);
		jsonMap.put(MESSAGE, message);
		return jsonMap;
	}

	/**
	 * @author zhsd
	 * @description 输出JSON成功消息
	 * @param message
	 * @return Map
	 */
	public Map<String, Object> ajaxJsonSuccessMessage(String message) {
		return this.ajaxJsonSuccessMessage(SUCCESS,message);
	}
	
	/**
	 * @author zhsd
	 * @description 输出JSON成功消息
	 * @param message
	 * @return Map
	 */
	public Map<String, Object> ajaxJsonSuccessMessage(Object success,String message) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(STATUS, success);
		jsonMap.put(MESSAGE, message);
		return jsonMap;
	}

	/**
	 * @author zhsd
	 * @description 输出JSON错误消息
	 * @param message
	 * @return Map
	 */
	public Map<String, Object> ajaxJsonErrorMessage(String message) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(STATUS, ERROR);
		jsonMap.put(MESSAGE, message);
		return jsonMap;
	}
	
	/**
	 * @author zhsd
	 * @description 输出JSON错误消息
	 * @return Map
	 */
	public Map<String, Object> ajaxJsonErrorMessage(Exception e) {
		logger.error("error", e);
		e.printStackTrace();
		return ajaxJsonErrorMessage("请稍等，正在处理");
	}

	/**
	 * @author zhsd
	 * @description 异常处理
	 * @param e
	 * @return String
	 */
	public String dealExceptionMessage(Exception e){
		logger.error("exception", e);
		e.printStackTrace();
		return "/common/error";
	}

}
