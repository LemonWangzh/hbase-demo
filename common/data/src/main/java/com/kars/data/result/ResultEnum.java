package com.kars.data.result;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public enum ResultEnum implements IResult {

    //RPC层调用错误码
    SUCCESS(10000, "成功", "Success"),
    METHOD_NOT_ALLOWED(10100, "Method Not Allowed","Method Not Allowed"),
    UNKONW_ERROR(10101, "系统异常，请稍后重试", "System exception, please try again later"),
    FAILED(10102, "传入参数不合法", "Illegal parameter"),
    ;

    private final String zhCnMsg;

    private final String enUsMsg;
    private final Integer code;

    static final Map<Integer, ResultEnum> resultMap;

    static {
        resultMap = Arrays.stream(ResultEnum.values())
                .collect(Collectors.toMap(ResultEnum::getCode, Function.identity()));
    }

    public static ResultEnum getInstance(Integer code) {
        if (code == null) {
            throw new IllegalArgumentException("param code is null");
        }
        return resultMap.get(code);
    }

    ResultEnum(int code, String zhCnMsg, String enUsMsg) {
        this.zhCnMsg = zhCnMsg;
        this.enUsMsg = enUsMsg;
        this.code = code;
    }

    @Override
    public String getMsg() {
        return this.zhCnMsg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }


    @Override
    public String toString() {
        return "ResultEnum{" +
                "zhCnMsg='" + zhCnMsg + '\'' +
                ", enUsMsg='" + enUsMsg + '\'' +
                ", code=" + code +
                '}';
    }
}

