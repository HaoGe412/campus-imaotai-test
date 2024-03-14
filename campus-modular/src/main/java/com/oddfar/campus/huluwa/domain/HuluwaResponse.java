package com.oddfar.campus.huluwa.domain;

import lombok.Data;

/**
 * @ClassName HuluwaResponse
 * @Description TODO
 * @Author kgy0809@163.com
 * @Date 2024-03-14 14:14
 * @Version 1.0
 **/
@Data
public class HuluwaResponse {
    private String traceId;
    private Long serverTimeStamp;
    private String code;
    private boolean success;
    private String data;
    private String message;
}
