package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Bill;
import com.example.demo.service.BillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-04-13 15:35
 **/
@RestController
@RequestMapping("/api")
@Slf4j
public class HomeController {
    //private static final Logger logger= LogManager.getLogger(HomeController.class);

    @Autowired
    private BillService billService;

    //http://localhost:8080/api/query?start=2021-02-07%2000:00:00&end=2021-03-07%2000:00:00
    @RequestMapping("/query")
    public List<Bill> queryList(@RequestParam("start") String start, @RequestParam("end") String end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            log.info("查询开始：");
            Date date = sdf.parse(start);
            Date date2 = sdf.parse(end);
            QueryWrapper<Bill> queryWrapper = new QueryWrapper<>();
            queryWrapper.ge("create_time", date)
                    .and(qw -> qw.le("create_time", date2)).last("limit 0,10");
            List<Bill> billIPage = billService.list(queryWrapper);
            System.out.println(billIPage.size());
            //billIPage.forEach(System.out::println);

            return billIPage;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    //分页信息

    /**
     * 数据库分表场景下， 分页列表查询 示例
     */
    @RequestMapping("/queryPage")
    public PageInfo<Bill> queryPage(@RequestParam("start") String start,
                                    @RequestParam("end") String end,
                                    @RequestParam("pageNum") int pageNum,
                                    @RequestParam("pageSize") int pageSize
    ) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            PageHelper.startPage(pageNum, pageSize);
            log.info("查询开始：");
            Date date = sdf.parse(start);
            Date date2 = sdf.parse(end);
            QueryWrapper<Bill> queryWrapper = new QueryWrapper<>();
            queryWrapper.ge("create_time", date)
                    .and(qw -> qw.le("create_time", date2));
            //1.MybatisPlus 使用方法
            //List<Bill> billIPage = billService.list(queryWrapper);
            //2.xml 自定义sql语句查询
            List<Bill> billIPage = billService.selectList(start, end);
            PageInfo<Bill> pageInfo = new PageInfo<>(billIPage);
            // PageUtils.endPage(billIPage, pageParam);
            return pageInfo;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //http://localhost:8080/api/save?userid=999&addressId=999&status=M&date=2021-03-07%2000:00:00
    @RequestMapping("/save")
    public String Save(@RequestParam("userid") int userId, @RequestParam("addressId") long AddressId,
                       @RequestParam("status") String status
            , @RequestParam("date") String strDate) {
        String ret = "0";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(strDate);
            Bill bill = new Bill();
            bill.setUserId(userId);
            bill.setAddressId(AddressId);
            bill.setStatus(status);
            bill.setCreateTime(date);
            boolean isOk = billService.save(bill);
            if (isOk) {
                ret = "1";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }
 /*   @RequestMapping("/save")
    public void testBillSave(){
        for (int i = 0 ; i< 120 ; i++){
            Bill bill = new Bill();
            bill.setUserId(i);
            bill.setAddressId((long)i);
            bill.setStatus("K");
            bill.setCreateTime((new Date(new DateTime(2022,(i % 11)+1,7,00, 00,00,000).getMillis())));
            billService.save(bill);
        }
    }*/
}
