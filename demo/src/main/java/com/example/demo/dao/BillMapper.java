package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-04-13 15:31
 **/
@Mapper
public interface BillMapper extends BaseMapper<Bill> {

    List<Bill> queryList(@Param("dateStart") String dateStart, @Param("dateEnd") String dateEnd);
}
