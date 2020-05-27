package com.jex.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 错误消息实体
 * </p>
 *
 * @author Jex
 * @since 2020-01-08
 */
@Data
public class ErrorInfo implements Serializable {
    private static final long serialVersionUID = 6001966082338217014L;
    private String code;
    private String message;

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
