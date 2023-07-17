package com.kars.data.exception;

import com.kars.data.result.IResult;
import com.kars.data.result.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 自定义基础异常类
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException implements IResult {

	private Integer code;
	private String msg;

    public BaseException(String message) {
        super(message);
        this.code = ResultEnum.UNKONW_ERROR.getCode();
    }

    public BaseException(IResult iResult) {
        super(iResult.getMsg());
        this.code = iResult.getCode();
    }

    public BaseException(IResult iResult, String msg) {
        super(msg);
        this.code = iResult.getCode();
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
        this.code = ResultEnum.UNKONW_ERROR.getCode();
    }

    public BaseException(IResult iResult, Throwable cause) {
        super(iResult.getMsg(), cause);
        this.code = iResult.getCode();
    }
}
