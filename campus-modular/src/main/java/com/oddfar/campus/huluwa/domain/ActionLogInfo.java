package com.oddfar.campus.huluwa.domain;

import com.oddfar.campus.huluwa.enums.PlatformEnum;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName ActionLogInfo
 * @Description TODO
 * @Author kgy0809@163.com
 * @Date 2024-03-14 14:10
 * @Version 1.0
 **/
@Data
public class ActionLogInfo {

    private PlatformEnum platform;
    private String token;
    private String message;
    private Date stamp;
}
