package com.example.demo;

import com.example.demo.dao.CityMapper;
import com.example.demo.model.City;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaClientApplicationTests {

	@Autowired
	RestTemplate restTemplate;

	@Test
	public void contextLoads() {
		System.out.println(restTemplate.getForEntity("http://localhost:2000/greeting", String.class).getBody());
	}

	@Autowired
	CityMapper cityMapper;

	@Test
	@Rollback
	@Transactional
	public void tttt(){
		PageHelper.startPage(1,20);
//		List<City> citys = cityMapper.
		System.out.println("-----------------------------");
		City city = cityMapper.selectByPrimaryKey(1);
		System.out.println(city);
		city.setStatus(1);
		cityMapper.updateByPrimaryKey(city);
		System.out.println(cityMapper.selectByPrimaryKey(1));
		System.out.println("-----------------------------");
	}

}
