package com.example.demo.dao;

import com.example.demo.model.Number;
import com.example.demo.model.NumberExample;
import java.util.List;

import com.example.demo.util.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface NumberMapper  extends MyMapper<Number> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table number
     *
     * @mbggenerated
     */
    int countByExample(NumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table number
     *
     * @mbggenerated
     */
    int deleteByExample(NumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table number
     *
     * @mbggenerated
     */
    int insert(Number record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table number
     *
     * @mbggenerated
     */
    int insertSelective(Number record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table number
     *
     * @mbggenerated
     */
    List<Number> selectByExample(NumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table number
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Number record, @Param("example") NumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table number
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Number record, @Param("example") NumberExample example);
}