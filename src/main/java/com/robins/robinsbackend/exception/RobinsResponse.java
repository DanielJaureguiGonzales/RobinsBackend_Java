package com.robins.robinsbackend.exception;

import java.io.Serializable;


public class RobinsResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String status;
    private String message;
    private T data;

    public RobinsResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public RobinsResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}