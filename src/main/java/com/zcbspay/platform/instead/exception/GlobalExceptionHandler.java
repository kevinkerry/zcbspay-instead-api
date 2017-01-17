package com.zcbspay.platform.instead.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorFormInfo handleMethodArgumentNotValid(HttpServletRequest req,
      MethodArgumentNotValidException ex) {
    logger.error("参数绑定错误", ex);
    String errorURL = req.getRequestURL().toString();

    ErrorFormInfo errorInfo = new ErrorFormInfo(errorURL, "参数有误");

    BindingResult result = ex.getBindingResult();
    List<FieldError> fieldErrors = result.getFieldErrors();

    errorInfo.getFieldErrors().addAll(populateFieldErrors(fieldErrors));

    return errorInfo;
  }

//  @ExceptionHandler(AuthenticationException.class)
//  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//  @ResponseBody
//  public ErrorFormInfo handleAuthenticationException(HttpServletRequest req,
//      AuthenticationException e) {
//    logger.error("认证错误", e);
//    String errorURL = req.getRequestURL().toString();
//
//    ErrorFormInfo errorInfo = new ErrorFormInfo(errorURL, "认证错误");
//
//    return errorInfo;
//  }


  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorFormInfo handleBindException(HttpServletRequest req, RuntimeException ex) {
    logger.error(ex);
    String errorURL = req.getRequestURL().toString();

    ErrorFormInfo errorInfo = new ErrorFormInfo(errorURL, ex.getMessage());

    return errorInfo;
  }



  @ExceptionHandler(BindException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorFormInfo handleBindException(HttpServletRequest req, BindException ex) {
    logger.error(ex);
    
    String errorURL = req.getRequestURL().toString();

    ErrorFormInfo errorInfo = new ErrorFormInfo(errorURL, "参数有误");

    BindingResult result = ex.getBindingResult();
    List<FieldError> fieldErrors = result.getFieldErrors();

    errorInfo.getFieldErrors().addAll(populateFieldErrors(fieldErrors));

    return errorInfo;
  }

  /**
   * Method populates {@link List} of {@link FieldErrorDTO} objects. Each list item contains
   * localized error message and name of a form field which caused the exception. Use the
   * {@link #localizeErrorMessage(String) localizeErrorMessage} method.
   * 
   * @param fieldErrorList - {@link List} of {@link FieldError} items
   * @return {@link List} of {@link FieldErrorDTO} items
   */
  public List<FieldErrorDTO> populateFieldErrors(List<FieldError> fieldErrorList) {
    List<FieldErrorDTO> fieldErrors = new ArrayList<FieldErrorDTO>();
    StringBuilder errorMessage = new StringBuilder("");

    for (FieldError fieldError : fieldErrorList) {

      errorMessage.append(fieldError.getCode()).append(".");
      errorMessage.append(fieldError.getObjectName()).append(".");
      errorMessage.append(fieldError.getField());


      fieldErrors.add(new FieldErrorDTO(fieldError.getField(), fieldError.getDefaultMessage()));
      errorMessage.delete(0, errorMessage.capacity());
    }
    return fieldErrors;
  }

}
