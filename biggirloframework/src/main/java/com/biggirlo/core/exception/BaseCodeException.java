package com.biggirlo.core.exception;

import com.biggirlo.core.http.response.AbstractCode;
import com.biggirlo.core.http.response.Code;

/**
 * 基础实现类
 */
public class BaseCodeException extends AbstractRuntimeException {

    private AbstractCode code;

    @Override
    public long getExceptionCode() {
        return code.value();
    }

    public BaseCodeException(AbstractCode code){
        super(code.msg());
        this.code = code;
    }
}
