package com.example.demo.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request ,Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Exception" ,e);
        modelAndView.addObject("url",request.getRequestURI());
        modelAndView.setViewName("erorr");
        return modelAndView;
    }
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData json(Exception ex){
        logger.error("Exception",ex);
        if (ex instanceof IllegalArgumentException){
            ResponseData rd = new ResponseData();
            rd.setCode(3000);
            rd.setMsg(ex.getMessage());
            return rd;
        }else {
            ResponseData rd = new ResponseData();
            rd.setCode(4000);
            rd.setMsg("system error");
            return rd;
        }
    }

}
