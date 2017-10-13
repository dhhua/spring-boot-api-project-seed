package com.dredh.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  SystemResultConst implements ResultConst {
    ENTITY_NOT_FOUND(40004, "entity not found"),
    SUCCESS(200, "success");
    private int code;
    private String message;
}
