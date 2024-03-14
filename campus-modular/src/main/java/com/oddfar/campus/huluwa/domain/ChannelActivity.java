package com.oddfar.campus.huluwa.domain;

import lombok.Data;

/**
 * @ClassName ChannelActivity
 * @Description TODO
 * @Author kgy0809@163.com
 * @Date 2024-03-14 14:12
 * @Version 1.0
 **/
@Data
public class ChannelActivity extends BaseResult {
    private Integer id;
    private String name;
    private Integer playMode;
    private Integer isAppoint;
    private Integer appointCounts;
    private Long startTime;
    private Long endTime;
    private Long appointStartTime;
    private Long appointEndTime;
    private Long purchaseStartTime;
    private Long purchaseEndTime;
    private Long drawTime;
}
