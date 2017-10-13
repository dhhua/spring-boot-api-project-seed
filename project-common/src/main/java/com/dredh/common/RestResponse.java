package com.dredh.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class RestResponse {

    private int code;
    private String message;
    private Object data;

    public static RestResponse build(Object data) {
        return build(SystemResultConst.SUCCESS, data);
    }

    public static RestResponse build(ResultConst resultConst, Object data) {
        return new RestResponse(resultConst.getCode(), resultConst.getMessage(), data);
    }
}
