package com.example.demo.service;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Bill;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-04-13 15:37
 **/
public class OrderServiceImplTest  {
   /* @Autowired
    private BillService billService;
    @Test
    public void testBillSave(){
        for (int i = 0 ; i< 120 ; i++){
            Bill bill = new Bill();
            bill.setUserId(i);
            bill.setAddressId((long)i);
            bill.setStatus("K");
            bill.setCreateTime((new Date(new DateTime(2021,(i % 11)+1,7,00, 00,00,000).getMillis())));
            billService.save(bill);
        }
    }
    @Test
    public void testGetByOrderId(){
        long id = 626038622575374337L; //根据数据修改，无数据会报错
        QueryWrapper<Bill> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", id);
        Bill bill = billService.getOne(queryWrapper);
        System.out.println(bill.toString());
    }

    @Test
    public void testGetByDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse("2021-02-07 00:00:00");
            QueryWrapper<Bill> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("create_time",date);
            List<Bill> billIPage = billService.list(queryWrapper);
            System.out.println(billIPage.size());
            System.out.println(billIPage.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetByDate2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse("2021-02-07 00:00:00");
            Date date2 = sdf.parse("2021-03-07 00:00:00");
            QueryWrapper<Bill> queryWrapper = new QueryWrapper<>();
            queryWrapper.ge("create_time",date)
                    .and(qw-> qw.le("create_time", date2));
            List<Bill> billIPage = billService.list(queryWrapper);
            System.out.println(billIPage.size());
            billIPage.forEach(System.out::println);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }*/
}
