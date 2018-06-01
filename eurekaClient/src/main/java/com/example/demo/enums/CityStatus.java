package com.example.demo.enums;

public enum CityStatus {
    ENABLE(0,"启用"),
    DISABLE(1,"禁用");

    private String content;
    private Integer code;

    CityStatus(Integer index,String content){
        this.code = index;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getContent(Integer index) {
        return values()[index].content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    }


