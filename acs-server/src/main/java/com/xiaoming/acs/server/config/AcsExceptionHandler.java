package com.xiaoming.acs.server.config;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.sql.SQLException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;

import com.xiaoming.acs.common.enums.ErrorCodeEnum;
import com.xiaoming.acs.common.exception.BizException;
import com.xiaoming.acs.common.vo.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yanming03
 * @version 1.0
 * @date 2022/8/29 15:23
 * @description mvc 异常捕获
 */
@Slf4j
@RestControllerAdvice
public class AcsExceptionHandler {

    @ExceptionHandler(BizException.class)
    public Result<?> handleBizException(BizException e) {
        log.error("BizException", e);
        return Result.error(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException", e);
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder("参数校验失败: ");
        String prefix = "";
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(prefix).append(fieldError.getField()).append(" ").append(fieldError.getDefaultMessage());
            prefix = ",";
        }
        sb.append(". ");
        return Result.error(ErrorCodeEnum.ACCESS_PARAMS_ERROR.getCode(), sb.toString());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result<?> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("IllegalArgumentException", e);
        return Result.error(ErrorCodeEnum.ACCESS_PARAMS_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Result<?> handleConstraintViolationException(ConstraintViolationException e) {
        log.error("ConstraintViolationException", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        StringBuilder msg = new StringBuilder();
        for (ConstraintViolation<?> item : violations) {
            msg.append(item.getMessage());
        }
        return Result.error(ErrorCodeEnum.ACCESS_PARAMS_ERROR.getCode(), msg.toString());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("MissingServletRequestParameterException", e);
        String str = String.format("必填参数: [%s] 为空", e.getParameterName());
        return Result.error(ErrorCodeEnum.ACCESS_PARAMS_INCOMPLETE.getCode(), str);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("MethodArgumentTypeMismatchException", e);
        String str = String.format("参数: [%s] 类型错误", e.getName());
        return Result.error(ErrorCodeEnum.ACCESS_PARAMS_ERROR.getCode(), str);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("HttpMessageNotReadableException", e);
        return Result.error(ErrorCodeEnum.ACCESS_PARAMS_JSON_INVALID);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("HttpRequestMethodNotSupportedException", e);
        String str = String.format("请求方法: [%s] 不支持", e.getMethod());
        return Result.error(ErrorCodeEnum.ACCESS_REQUEST_METHOD_ERROR.getCode(), str);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result<?> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        log.error("HttpMediaTypeNotSupportedException", e);
        String str = String.format("Content-Type: [%s] 不支持", e.getContentType());
        return Result.error(ErrorCodeEnum.ACCESS_CONTENT_TYPE_ERROR.getCode(), str);
    }

    @ExceptionHandler(MultipartException.class)
    public Result<?> handleMultipartException(MultipartException e) {
        log.error("MultipartException", e);
        return Result.error(ErrorCodeEnum.ACCESS_FILE_ERROR);
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> handleIllegalStateException(IllegalStateException e) {
        log.error("IllegalStateException", e);
        return Result.error(ErrorCodeEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> handleNullPointerException(NullPointerException e) {
        log.error("NullPointerException", e);
        return Result.error(ErrorCodeEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> handleOtherException(Exception e) {
        log.error("handleOtherException", e);
        if (e instanceof SQLException) {
            return Result.error(ErrorCodeEnum.INTERNAL_SQL_ERROR);
        }
        if (e instanceof ConnectException) {
            return Result.error(ErrorCodeEnum.EXTERNAL_CONNECT_ERROR);
        }
        if (e instanceof SocketTimeoutException) {
            return Result.error(ErrorCodeEnum.EXTERNAL_SOCKET_TIMEOUT_ERROR);
        }
        if (e instanceof IOException) {
            return Result.error(ErrorCodeEnum.INTERNAL_IO_ERROR);
        }
        return Result.error(ErrorCodeEnum.SYSTEM_ERROR);
    }
}
