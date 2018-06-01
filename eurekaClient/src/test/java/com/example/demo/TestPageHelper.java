package com.example.demo;

import com.example.demo.dao.NumberMapper;
import com.example.demo.model.Number;
import com.example.demo.model.NumberExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPageHelper {

    @Autowired
    private NumberMapper numberMapper;

    @Autowired
    private ApplicationContext context;

    @Test
    public void test() {

       // 创建一个spring容器
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*");
        // 从spring容器中获取mapper代理对象
//        NumberMapper mapper = context.getBean(NumberMapper.class);
        // 执行查询并分页,TbItemExample是逆向工程自动生成的，用来进行条件查询，这里不设置则表示无条件
        NumberExample example = new NumberExample();
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(1, 10);
       // List<Number> list =
          List<Number> list  =      numberMapper.selectByExample(example);//查询
        // 取商品列表
        for(Number item  : list) {
            System.out.println(item.getPage());//.getTitle());
        }
        // 取分页信息
        PageInfo<Number> pageInfo = new PageInfo<Number>(list);
        long total = pageInfo.getTotal(); //获取总记录数
        System.out.println("共有商品信息：" + total);
        System.out.println(pageInfo.getList());
    }
}
