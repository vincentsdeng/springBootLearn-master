package com.example.demo.util;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 6514891174875747380L;
    /** 异常错误码 **/
    /**
     * ServiceException构造方法，有format字符组
     * @param errorCode 错误码
     * @param param     format字符组
     * @param extMsg    扩展信息，给出具体的错误值信息等
     */

    private String errorCode;


    public String getErrorCode() {
        return "错误码";
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }






}

