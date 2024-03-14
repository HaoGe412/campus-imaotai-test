package com.oddfar.campus.huluwa.domain;

import lombok.Data;

/**
 * @ClassName CustomerInfo
 * @Description TODO
 * @Author kgy0809@163.com
 * @Date 2024-03-14 14:13
 * @Version 1.0
 **/
@Data
public class CustomerInfo extends BaseResult {
    private String openId;
    private String headUrl;
    private String realName;
    private Boolean b2b;
    private Boolean isReadNotice;
    private String phone;
    private Boolean isRealNameAuth;
    private String idcard;
    private String nickname;
    private Integer custType;
    private Boolean phoneIsBind;
    private Boolean isModifyAuth;
    private String status;
}
