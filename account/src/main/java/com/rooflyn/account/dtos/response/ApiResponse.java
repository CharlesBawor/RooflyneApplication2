package com.rooflyn.account.dtos.response;

import com.rooflyn.account.constants.ResponseConstant;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApiResponse<T> {
    private String statusCode;

    private String statusMessage;

    private T data;

    private LocalDateTime timeStamp;

    //Constructor

    public ApiResponse(String statusCode, String statusMessage, T data) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse() {
    }

    //Getters and Setters


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}

