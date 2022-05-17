package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-04-13 15:29
 **/
@Data
@TableName("t_bill")
public class Bill {
    private Long orderId;
    private Integer userId;
    private Long addressId;
    private String status;
    private Date createTime;
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
