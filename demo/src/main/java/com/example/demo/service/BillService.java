package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Bill;

import java.util.Date;
import java.util.List;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-04-13 15:32
 **/
public interface BillService extends IService<Bill> {

    List<Bill> selectList(String dateStart, String dateEnd);

}
