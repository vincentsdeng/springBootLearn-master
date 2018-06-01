package com.example.demo.web;
import com.example.demo.dao.CityMapper;
import com.example.demo.model.City;
import com.example.demo.model.qo.CityQo;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@Transactional
public class CityCURDController {
    //统一异常处理
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private CityService cityService;

    //单条插入
    @RequestMapping("/addOne")
    @ResponseBody
    public int addOne(@RequestBody City city) {
        if (city == null || city.getName() == null||city.getId() ==null) {
            throw new IllegalArgumentException("参数有误");
        }
        if (city.getId() != null) {
            City city1 = cityMapper.selectByPrimaryKey(city);
            if(city1!=null) {
                city.getId().equals(city1.getId());
                throw new IllegalArgumentException("ID相同");
            }else {

                return cityService.addOne(city);
            }

        }
        return 0;
    }
    //多条插入
    @PostMapping("/addList")
    @ResponseBody
    public String addList(@RequestBody CityQo qo){

        if (qo == null || qo.getCitys() == null) {
            throw new IllegalArgumentException("参数有误");
        }
        cityService.addList(qo.getCitys());

        return "ok";


    }
    //单条删除
    @RequestMapping("/deleteOne")
    @ResponseBody
     public  int deleteOne(@RequestBody City city){
        if(city == null || city.getId()==null){
            throw new IllegalArgumentException("参数有误");
        }
        cityMapper.delete(city);
        return 1;
    }

    //批量删除
    @RequestMapping("/batchDelete")
    @ResponseBody
    public  String batchDelete(@RequestBody CityQo qo){
        if(qo == null || qo.getCitys() == null ){
            throw new IllegalArgumentException("参数有误");
        }
          cityService.batchDelete(qo.getCitys());

        return "ok";
    }
    //根据ID查单条
    @RequestMapping("/selectId")
    @ResponseBody
    public String  selectId(@RequestBody  City city){
        if (city == null) {
            throw new IllegalArgumentException("参数有误！");
        }

       City C =cityService.getCitySelectId(city);

        return "OK "+C.toString();


    }
    //查全部
    @RequestMapping("/selectAll")
    @ResponseBody
    public  String  selectAll(@RequestBody CityQo qo){
        if (qo==null || qo.getId()==null){
            throw new IllegalArgumentException("erorr");
        }

        List<City> C = cityService.selectByList(qo.getCitys());

        return "OK "+C.toString();

    }
    //模糊查询
    @RequestMapping("/selectLike")
    @ResponseBody
    public  String  selectLike(@RequestBody  City citys){
        if (citys==null || citys.getName()==null){
            throw new IllegalArgumentException("erorr");
        }
       List<City> CS=  cityService.vagueSelect(citys);
        return"OK"+ CS.toString();
    }

    //改变状态

    //更新

    //分页
}
