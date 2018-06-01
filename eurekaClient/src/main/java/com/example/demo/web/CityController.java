package com.example.demo.web;
import com.example.demo.dao.CityMapper;
import com.example.demo.enums.CityStatus;
import com.example.demo.model.City;
import com.example.demo.service.CityService;
import com.example.demo.util.CommonNoticeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class CityController {
    private final static Logger logger = LoggerFactory.getLogger(CityController.class);
    @Autowired
    private CityMapper cityMapper;

    @PostMapping("/cityInsert")
    public String cityInsert(@RequestBody City city) {
        if (city.getId() != null || city.getName() != null) {
            city.setId(city.getId());
            city.setName(city.getName());
            city.setStatus(city.getStatus());
            city.setCountry(city.getCountry());
            cityMapper.insert(city);
            System.out.println(city);
        }
        cityMapper.updateByPrimaryKey(city);
        logger.info("result:" + city);
        return "OK" + "" + city;
    }

    @RequestMapping("/cityDelete")
    public String cityDelete(@RequestBody City city) {
        try {
            cityMapper.delete(city);
        } finally {
            Object O = cityMapper.updateByPrimaryKey(city);
            System.out.println(O.toString());
        }
        return "ok" + "" + city;
    }

    @RequestMapping("citySelect")
    public String citySelect() {
        City city = cityMapper.selectAll().get(0);
        System.out.println(city);
        city.setStatus(0);
        city.getCreateTime();
        city.getUpdateTime();
        cityMapper.updateByPrimaryKey(city);
        City city2 = cityMapper.selectByPrimaryKey(3);
        System.out.println(city2.toString());
        return "ok" + "" + city;
    }

    @PostMapping("cityUpdate")
    public String cityUpdate(City city, Object O) {

        cityMapper.updateByExample(city, O);
        return null;
    }

    @Autowired
    private CityService cityService;

    @PostMapping("/enable")
    public String enable(City city) {
        if (city == null || city.getId() == null){
            return CommonNoticeInfo.ILLEGAL_ARGUMENT_INFO;
        }
        City srcCity = cityService.getCityById(city.getId());
        if (srcCity == null){
            return CommonNoticeInfo.ILLEGAL_ARGUMENT_INFO;
        }
        if (cityService.doEnableCity(srcCity)){
            return "ok";
        }else{
            return "fail";
        }
    }

    @PostMapping("/disable")
    public String disable(City city) {
        if (city == null || city.getId() == null){
            return CommonNoticeInfo.ILLEGAL_ARGUMENT_INFO;
        }
        City srcCity = cityService.getCityById(city.getId());
        if (srcCity == null){
            return CommonNoticeInfo.ILLEGAL_ARGUMENT_INFO;
        }
        if (cityService.doDisableCity(srcCity)){
            return "ok";
        }else{
            return "fail";
        }
    }

    @PostMapping("/updateStatus")
    public String updateStatus(City city) {
        if (city == null || city.getId() == null){
            return CommonNoticeInfo.ILLEGAL_ARGUMENT_INFO;
        }
        City srcCity = cityService.getCityById(city.getId());
        if (srcCity == null){
            return CommonNoticeInfo.ILLEGAL_ARGUMENT_INFO;
        }
        boolean result_flag;
        if (CityStatus.ENABLE.getCode().equals(srcCity.getStatus())){
            result_flag = cityService.doDisableCity(srcCity);
        }else{
            result_flag = cityService.doEnableCity(srcCity);
        }
        if (result_flag){
            return "ok";
        }else{
            return "fail";
        }
    }
    //如果返回list不能做校验需要用SpringAOP做异常拦截
    @RequestMapping("vagueSelect")
    public List<City> vagueSelect (City city){
        if (city == null || city.getName()==null){

            throw new IllegalArgumentException("enter name.please!");
        }else {
          return  cityService.vagueSelect(city);
        }

    }




 }