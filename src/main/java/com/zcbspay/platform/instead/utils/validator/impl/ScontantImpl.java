/* 
 * ScontantImpl.java  
 * 
 * version TODO
 *
 * 2016年5月31日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zcbspay.platform.instead.utils.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.zcbspay.platform.instead.utils.StringUtil;
import com.zcbspay.platform.instead.utils.validator.Scontant;

/**
 * 字符串常量
 *
 * @author Luxiaoshuai
 * @version
 * @date 2016年5月31日 上午10:47:54
 * @since
 */
public class ScontantImpl implements ConstraintValidator<Scontant, String> {
	private String[] contants;
	private boolean isNull;

	/**
	 * 初始参数,获取注解中length的值
	 */
	@Override
	public void initialize(Scontant arg0) {
		this.isNull = arg0.isNull();
		this.contants = arg0.contants();
	}

	@Override
	public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
		if (isNull == true && StringUtil.isEmpty(str)) {
			return true;
		} else {
			boolean isok = false;
			if (StringUtil.isNotEmpty(str)) {
				for (String a : contants) {
					if (a.equals(str)) {
						isok = true;
					}
				}
			} else {
				constraintValidatorContext.disableDefaultConstraintViolation();// 禁用默认的message的值
				// 重新添加错误提示语句
				constraintValidatorContext.buildConstraintViolationWithTemplate("该域不能为空").addConstraintViolation();
			}
			return isok;
		}
	}
}