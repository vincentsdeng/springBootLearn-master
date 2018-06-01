package com.example.demo.model.qo;

import com.example.demo.model.City;

import java.util.List;

public class CityQo {
    List<City> citys;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    public List<City> getCitys() {
        return citys;
    }

    public void setCitys(List<City> citys) {
        this.citys = citys;
    }
}
