package com.example.demo.Enums;

public enum  CityStatus {

    CLOSE(2,"关闭"),
    OPEN(1,"开启");

    private  Integer code;
    private  String context;

    CityStatus(Integer code ,String context ) {
        this.code = code;
        this.context = context;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
