package com.oddfar.campus.huluwa.domain;

import com.oddfar.campus.huluwa.enums.PlatformEnum;
import lombok.Data;

/**
 * @ClassName BaseParam
 * @Description TODO
 * @Author kgy0809@163.com
 * @Date 2024-03-14 14:11
 * @Version 1.0
 **/
@Data
public class BaseParam {

    private PlatformEnum platform;
    private String token;
}
