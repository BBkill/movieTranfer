package core;


import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Log4j2
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1232424234L;

    public static final String SUCCESSFUL_MESSAGE = "OK";

    private Integer code = ResultEnum.ERROR.getCode();

    private Object other;

    private String msg = null;

    private T data = null;

    public Result() {
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, Object other, String msg, T data) {
        this.code = code;
        this.other = other;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> failOther(String msg, Object code) {
        return new Result<T>(ResultEnum.FAIL.getCode(), msg,null,  code);
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getDesc();
    }


    public Result(int code, String msg, T data, Object other) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.other = other;
    }

    public static <T> Result<T> error(String msg) {
        log.debug("ERROR：code={}, msg={}", ResultEnum.ERROR.getCode(), msg);
        return new Result<T>(ResultEnum.ERROR.getCode(), msg, null);
    }

    public static <T> Result<T> fail(String msg) {
        log.debug("ERROR：code={}, msg={}", ResultEnum.FAIL.getCode(), msg);
        return new Result<T>(ResultEnum.FAIL.getCode(), msg, null);
    }


    public static <T> Result<T> paramInvalid() {
        log.debug("ERROR：code={}, msg={}", ResultEnum.PARAM_INVALID_ERROR.getCode(), ResultEnum.PARAM_INVALID_ERROR.getDesc());
        return new Result<T>(ResultEnum.PARAM_INVALID_ERROR);
    }

    public static <T> Result<T> paramInvalid(String msg) {
        log.debug("ERROR：code={}, msg={}", ResultEnum.PARAM_INVALID_ERROR.getCode(), msg);
        return new Result<T>(ResultEnum.PARAM_INVALID_ERROR.getCode(), msg, null);
    }

    public static <T> Result<T> error(ResultEnum resultEnum) {
        log.debug("ERROR：code={}, msg={}", resultEnum.getCode(), resultEnum.getDesc());
        return new Result<T>(resultEnum.getCode(), resultEnum.getDesc(), null);
    }

    public static <T> Result<T> error(int code, String msg) {
        log.debug("ERROR：code={}, msg={}", code, msg);
        return new Result<T>(code, msg, null);
    }

    public static <T extends Serializable> Result<T> error(int code, String msg, T data) {
        log.debug("ERROR：code={}, msg={}", code, msg);
        return new Result<T>(code, msg, data);
    }

    public static <T extends Serializable> Result<T> success(T data) {
        return new Result<T>(ResultEnum.SUCCESS.getCode(), SUCCESSFUL_MESSAGE, data);
    }

    public static <T> Result<T> successOther(Object data, Object code) {
        return new Result<T>(ResultEnum.SUCCESS.getCode(), SUCCESSFUL_MESSAGE, (T) data, code);
    }


    public static <T> Result<T> success(Object data) {
        return new Result<T>(ResultEnum.SUCCESS.getCode(), SUCCESSFUL_MESSAGE, (T) data);
    }

    public static <T> Result<T> success(Object other, Object data) {
        return new Result<T>(ResultEnum.SUCCESS.getCode(), other, SUCCESSFUL_MESSAGE, (T) data);
    }

    public static <T> Result<T> success() {
        return new Result<T>(ResultEnum.SUCCESS.getCode(), SUCCESSFUL_MESSAGE);
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

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }


}
