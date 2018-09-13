package com.biggirlo.core.exception;

/**
 * 王雁欣
 * 2018/9/10
 * 异常抽象类
 */
public abstract class AbstractRuntimeException extends RuntimeException {


    public abstract long getExceptionCode();

    public AbstractRuntimeException() {
    }

    public AbstractRuntimeException(String message) {
        super(message);
    }

    public AbstractRuntimeException(Throwable cause) {
        super(cause);
    }

    public AbstractRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
