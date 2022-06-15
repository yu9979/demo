package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: demo
 * @description: 描述
 * @author: wangjinyu
 * @date: 2022-05-27 17:23
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRecord implements Serializable {

    private static final long serialVersionUID = -3843548915035470817L;

    private String carNo;
    private String carColor;
    private String carType;

    private Date recordTime;
}
