package com.mkarakas.CustomGenericExceptionHandler.module.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.HashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyErrorResponse<R> implements Serializable {
    protected R data;
    protected HashMap<String,Object> response = new HashMap<>(10);

    protected static final String STATUS = "status";
    protected static final String ERROR_CODE = "errorCode";
    protected static final String MESSAGE = "message";
    protected static final String REQ_TIME = "reqTime";
    protected static final String ERROR_MESSAGE = "errorMessage";

    protected Long startTime = System.currentTimeMillis();
    protected Object params;

    //---------------------------------------------------Constructor
    public MyErrorResponse(){
    }

    public MyErrorResponse(boolean status, R data){
        this.response.put("status", status);
        this.data = data;
    }

    public MyErrorResponse(boolean status, String errorCode){
        this.response.put("status", status);
        this.response.put("errorCode", errorCode);
    }

    public MyErrorResponse(boolean status, String errorCode, String errorMessage){
        this.response.put("status", status);
        this.response.put("errorCode", errorCode);
        this.response.put("errorMessage",errorMessage);
    }

    //---------------------------------------------------toJson Method
    public String toJson() throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    //---------------------------------------------------Getter-Setter for My error response
    @JsonIgnore
    public boolean getStatus(){
        return (boolean) this.response.get("status");
    }
    public void setStatus(boolean status){
        this.response.put("status",status);
    }

    @JsonIgnore
    public String getErrorCode(){
        return (String) this.response.get("errorCode");
    }
    public void setErrorCode(String errorCode){
        this.response.put("errorCode",errorCode);
    }

    @JsonIgnore
    public String getMessage(){
        return (String) this.response.get("nessage");
    }
    public String getErrorMessage(){
        return (String) this.response.get("errorMessage");
    }
    public void setMessage(String message){
        this.response.put("message",message);
    }

    @JsonIgnore
    public Long getReqTime(){
        return (Long) this.response.get("reqTime");
    }
    public void setReqTime(Long reqTime){
        this.response.put("reqTime",reqTime);
    }
    public void setReqTime(){
        this.response.put("reqTime",System.currentTimeMillis() - this.startTime);
    }

    //---------------------------------------------------Getter-Setter

    public R getData() {
        return data;
    }
    public void setData(R data) {
        this.data = data;
    }

    public HashMap<String, Object> getResponse() {
        return response;
    }
    public void setResponse(HashMap<String, Object> response) {
        this.response = response;
    }

    public Long getStartTime() {
        return startTime;
    }
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Object getParams() {
        return params;
    }
    public void setParams(Object params) {
        this.params = params;
    }
}
