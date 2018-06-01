package com.example.demo;

import com.example.demo.dao.CityMapper;
import com.example.demo.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.genid.GenId;

import java.util.List;

/**
 * @auth snifferhu
 * @date 2018/3/8 01:39
 */
@RestController
@Transactional
public class ComputeController {
    private final static Logger logger = LoggerFactory.getLogger(ComputeController.class);


    @GetMapping(value = "/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        Integer r = a + b;
        City city = cityMapper.selectByPrimaryKey(1);
        System.out.println(city);
        return r;
    }


    @Autowired
    private CityMapper cityMapper;


    @GetMapping(value = "/infoQ")
    public String home() {
        City city = cityMapper.selectAll().get(0);
        System.out.println(city);
        city.setStatus(0);
        cityMapper.updateByPrimaryKey(city);
        City city2 = cityMapper.selectByPrimaryKey(2);
        System.out.println(city2);
        if (true){
            throw new RuntimeException();
        }
        city.setStatus(0);
        cityMapper.updateByPrimaryKey(city);
        logger.info("Access /");
        return "Hi!";
    }


    @PostMapping("updateCity")
    public String  updateCity(@RequestBody City c){
        c.setName("b");
        c.setStatus(1);
        c.setCountry("tt");
        Object O=cityMapper.insert(c);
        System.out.println(O.toString());
        if(true){
            cityMapper.updateByPrimaryKey(c);
            logger.info("result:" + c );
        }
        return "ok";

    }

}
