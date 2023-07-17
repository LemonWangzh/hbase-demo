package com.kars.data.exception;


import com.kars.data.result.CommonResult;
import com.kars.data.result.IResult;

/**
 * 业务错误
 */
public class BusinessException extends BaseException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(IResult iResult) {
        super(iResult);
    }

    public BusinessException(IResult iResult, String msg) {
        super(iResult, msg);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonResult<Object> getResultCode() {
        return CommonResult.create(getCode(),getMsg(),null);
    }
}
