package com.oddfar.campus.huluwa.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.oddfar.campus.huluwa.enums.PlatformEnum;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName RequestLog
 * @Description TODO
 * @Author kgy0809@163.com
 * @Date 2024-03-14 14:20
 * @Version 1.0
 **/
@Data
@TableName("request_log")
public class RequestLog {
    @TableId
    private Long id;
    private PlatformEnum platform;
    private String uri;
    private String content;
    private String token;
    private String response;
    private Long cost;
    private Integer status;
    private String message;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date stamp;
}
