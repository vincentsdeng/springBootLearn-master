package com.example.demo.service;

import com.example.demo.dao.CityMapper;
import com.example.demo.enums.CityStatus;
import com.example.demo.model.City;
import com.example.demo.model.CityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;

    public City getCityById(Integer id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    public Boolean doDisableCity(City city){
        city.setStatus(CityStatus.DISABLE.getCode());
        return updateCityStatus(city) == 1;
    }

    public Boolean doEnableCity(City city){
            city.setStatus(CityStatus.ENABLE.getCode());
        return updateCityStatus(city) == 1;
    }

    private Integer updateCityStatus(City city){
        city.setUpdateTime(new Date());
        return cityMapper.updateByPrimaryKey(city);
    }

    public List<City> vagueSelect(City city){
        return cityMapper.vagueSelect(city);
    }
    public String selectUpdate(City city){
        return cityMapper.selectUpdate(city).toString();
    }
    public int addOne(City city){
        return cityMapper.AddOne(city);
    }

    public int addList(List<City> city){
        return cityMapper.insertList(city);
    }

    public int delete(City city){
        CityExample example = new CityExample();
        CityExample.Criteria cri = example.createCriteria();
        if (!StringUtils.isEmpty(city.getName()))cri.andNameEqualTo(city.getName());
        if (city.getStatus() != null) cri.andStateEqualTo(city.getStatus().toString());
        if (!StringUtils.isEmpty(city.getCountry()))cri.andCountryEqualTo(city.getCountry());
        return cityMapper.deleteByExample(example);
    }

    public  int batchDelete(List<City> city){
        return cityMapper.batchDelete(city);
    }
    public City getCitySelectId(City city){
        return cityMapper.selectOne(city);
    }

    public  List<City>  selectByList(List<City> citys){
        return cityMapper.queryByAppointmentDate(citys);
    }
}
