package com.middleware.backend.dto;

public class SuccessResponse {

    private final Integer statuscode = 200;

    public Integer getStatuscode() {
        return statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
