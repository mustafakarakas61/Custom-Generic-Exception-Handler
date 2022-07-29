package com.mkarakas.CustomGenericExceptionHandler.controller;

import com.mkarakas.CustomGenericExceptionHandler.module.datamodel.MyErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

 //   @ApiOperation("Hello, i am a comment")
    @PostMapping("/homePage")
    public MyErrorResponse myMethod(@RequestParam String errorCode, @RequestParam String errorMessage, @RequestParam boolean status) throws Exception{
        MyErrorResponse response = new MyErrorResponse();
        response.setErrorCode(errorCode);
        response.setMessage(errorMessage);
        response.setStatus(status);
        response.setReqTime();
        return response;
    }

}
