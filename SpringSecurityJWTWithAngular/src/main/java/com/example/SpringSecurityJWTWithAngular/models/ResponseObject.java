package com.example.SpringSecurityJWTWithAngular.models;

public class ResponseObject {
    private String status;
    private String messeger;
    private Object data;

    public ResponseObject() {
    }

    public ResponseObject(String status, String messeger, Object data) {
        this.status = status;
        this.messeger = messeger;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMesseger() {
        return messeger;
    }

    public void setMesseger(String messeger) {
        this.messeger = messeger;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
