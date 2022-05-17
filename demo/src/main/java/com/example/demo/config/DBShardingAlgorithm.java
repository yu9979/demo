package com.example.demo.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-04-13 15:33
 **/
//自定义数据库分片算法
public class DBShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        //真实数据库节点
        availableTargetNames.stream().forEach((item) -> {
            System.out.println("actual db:" + item);
        });
        //逻辑表以及分片的字段名
        System.out.println("logicTable:"+shardingValue.getLogicTableName()+";shardingColumn:"+ shardingValue.getColumnName());
        //分片数据字段值
        System.out.println("shardingColumn value:"+ shardingValue.getValue().toString());
        //获取字段值
        long orderId = shardingValue.getValue();
        //分片索引计算 0 , 1
        //long db_index = orderId & (2 - 1);
        long db_index = orderId & (2 - 1);
        for (String each : availableTargetNames) {
            if (each.equals("ds"+db_index)) {
                //匹配的话，返回数据库名
                return each;
            }
        }
        throw new IllegalArgumentException();
    }
}
