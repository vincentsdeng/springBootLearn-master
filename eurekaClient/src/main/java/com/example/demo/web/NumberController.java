package com.example.demo.web;

import com.example.demo.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Number;

import java.util.List;

@RestController
public class NumberController {
    @Autowired
    private NumberService numberService;

    @PostMapping("/addNumber")
    public String addNumber(@RequestBody  Number number){
        if (number == null || number.getId() == null){
            return "params is wrong";
        }
        Number existCondition = numberService.selectById(number.getId());
        if (existCondition != null){
            return "number is exist.";
        }
        if (StringUtils.isEmpty(number.getName())){
            return "need name params.";
        }
        if (numberService.insertNumber(number)==1){
            return "ok";
        }else {
            return "fail";
        }
    }

    @GetMapping("/queryNumberByStatus")
    public List<Number> queryNumberByStatus(Integer status){
        if (status == null){
            return null;
        }
        return numberService.selectByStatus(status);
    }
}
