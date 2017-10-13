package com.dredh.controller;

import com.dredh.common.SystemResultConst;
import com.dredh.common.exception.BusinessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @RequestMapping("/hello")
    public String hello() {
        throw new RuntimeException();
    }

    @RequestMapping(value = "say", produces = "application/json")
    public String say() {
        return "say";
    }

    @RequestMapping("ex")
    public String businessException() {
        throw new BusinessException(SystemResultConst.ENTITY_NOT_FOUND);
    }

}
