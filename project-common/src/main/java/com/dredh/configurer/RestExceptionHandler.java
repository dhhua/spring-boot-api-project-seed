package com.dredh.configurer;

import com.dredh.common.RestResponse;
import com.dredh.common.exception.BusinessException;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@XSlf4j
public class RestExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public RestResponse handleBusinessException(BusinessException e) {
        log.catching(e);
        return new RestResponse(e.getCode(), e.getMessage(), "");
    }

    @ExceptionHandler(Throwable.class)
    public RestResponse handleOtherException(HttpServletRequest request, Throwable ex) {
        log.catching(ex);
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (code == null) {
            code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        }
        return new RestResponse(code, ex.getMessage(), "");
    }
}
