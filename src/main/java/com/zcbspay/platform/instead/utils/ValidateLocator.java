package com.zcbspay.platform.instead.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ValidateLocator {

	private static Validator validator;
	public static final String SYSTEM_ERROR = "订单信息错误,请重新提交订单";
	private static final Log logger = LogFactory.getLog(ValidateLocator.class);
//	private final static ResourceBundle RESOURCE = ResourceBundle.getBundle("validate_exception");

	public static <T> ValidateResultBean validateBeans(T obj) {
		ValidateResultBean resultBean = null;
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
		String message = SYSTEM_ERROR;
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			message = constraintViolation.getMessage() == null ? SYSTEM_ERROR : constraintViolation.getMessage();
			resultBean = new ValidateResultBean(constraintViolation.getPropertyPath().toString(), message);

			if (!resultBean.isResultBool()) {// 非空，长度检查出现异常，非法数据
				throw new RuntimeException("非空，长度检查出现异常，非法数据" + resultBean.getErrMsg());
			}
			return resultBean;
		}
		resultBean = new ValidateResultBean(obj);
		return resultBean;
	}

}
