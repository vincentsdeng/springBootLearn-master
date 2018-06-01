package com.example.demo.dao;

import com.example.demo.model.City;
import com.example.demo.util.MyMapper;
import java.util.List;

public interface CityMapper extends MyMapper<City> {

    List<City> vagueSelect(City city);
    Integer selectUpdate(City city);
    Integer AddOne(City city);

    Integer batchDelete(List<City> citys);

    List<City> queryByAppointmentDate(List<City> citys);
}