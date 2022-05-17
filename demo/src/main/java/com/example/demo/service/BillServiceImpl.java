package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.BillMapper;
import com.example.demo.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-04-13 15:32
 **/
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements BillService {

    @Autowired
    private BillMapper billMapper;

    @Override
    public List<Bill> selectList(String date, String date2) {
        List<Bill> list = billMapper.queryList(date,date2);
        return list;
    }
}
