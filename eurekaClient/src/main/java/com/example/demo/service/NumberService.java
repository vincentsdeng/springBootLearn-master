package com.example.demo.service;

import com.example.demo.dao.NumberMapper;
import com.example.demo.model.NumberExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Number;
import java.util.Date;
import java.util.List;

@Service
public class NumberService {
    @Autowired
    private NumberMapper numberMapper;

    public Number selectById(Integer id){
        return numberMapper.selectByPrimaryKey(id);
    }

    public Integer insertNumber(Number number){
        number.setCreateTime(new Date());
        number.setUpdateTime(new Date());
        number.setStatus(0);
        return numberMapper.insert(number);
    }

    public List<Number> selectByStatus(Integer status){

        NumberExample example = new NumberExample();
        example.createCriteria().andStatusEqualTo(status);
        example.setOrderByClause("createTime");
        return numberMapper.selectByExample(example);
    }
    public List<Number> selectByPage(Number number,Integer pageNum,Integer pageSize){
        NumberExample example = new NumberExample();
        example.createCriteria().andStatusEqualTo(number.getStatus());
        PageHelper.startPage(1, 20);
        return numberMapper.selectByExample(example);
    }
}
