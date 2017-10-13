package com.dredh.common.exception;

import com.dredh.common.ResultConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class BusinessException extends RuntimeException {

    private final int code;
    private final String message;

    public BusinessException(ResultConst result) {
        this.code = result.getCode();
        this.message = result.getMessage();
    }
}
