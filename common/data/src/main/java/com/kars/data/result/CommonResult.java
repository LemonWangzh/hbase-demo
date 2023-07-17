package com.kars.data.result;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kars.data.exception.BaseException;
import com.kars.data.exception.BusinessException;

import java.util.Objects;

public class CommonResult<T> {

    private Integer code;

    private String msg;

    private T data;

    private Object errorMsg;

    protected CommonResult() {

    }

    protected CommonResult(Integer code, String msg, T data, Object errorMsg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public static <T> CommonResult<T> create(Integer code, String msg, T data){
        return new CommonResult<>(code, msg, data, null);
    }

    public static CommonResult<Object> result(ResultEnum resultEnum) {
        return create(resultEnum.getCode(),resultEnum.getMsg(), null);
    }

    public static <T> CommonResult<T> success() {
        return new CommonResult<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), null, null);
    }


    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data, null);
    }

    public static <T> CommonResult<T> failed(IResult iResult) {
        return new CommonResult<>(iResult.getCode(), iResult.getMsg(), null, iResult.getMsg());
    }

    public static <T> CommonResult<T> failed(BaseException e) {
        return new CommonResult<>(e.getCode(), e.getMessage(), null, e.getMessage());
    }

    public static <T> CommonResult<T> failed(BusinessException e) {
        return new CommonResult<>(e.getCode(), e.getMessage(), null, e.getMessage());
    }

    public static <T> CommonResult<T> failed(IResult iResult, T data) {
        return new CommonResult<>(iResult.getCode(), iResult.getMsg(), data, iResult.getMsg());
    }

    public static <T> CommonResult<T> failed(BaseException e, T data) {
        return new CommonResult<>(e.getCode(), e.getMessage(), data, e.getMessage());
    }

    public static <T> CommonResult<T> failed() {
        return failed(ResultEnum.UNKONW_ERROR);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return code.equals(ResultEnum.SUCCESS.getCode());
    }

    @JsonIgnore
    public boolean isSuccessData() {
        return code.equals(ResultEnum.SUCCESS.getCode()) && Objects.nonNull(data);
    }

    @JsonIgnore
    public boolean isFailed() {
        return !isSuccess();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", errorMsg=" + errorMsg +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonResult<?> that = (CommonResult<?>) o;
        return Objects.equals(code, that.code) && Objects.equals(msg, that.msg) && Objects.equals(data, that.data) && Objects.equals(errorMsg, that.errorMsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, msg, data, errorMsg);
    }
}
