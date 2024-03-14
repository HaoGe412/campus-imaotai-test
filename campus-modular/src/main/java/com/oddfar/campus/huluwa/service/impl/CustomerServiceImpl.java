package com.oddfar.campus.huluwa.service.impl;

import com.oddfar.campus.huluwa.domain.CustomerInfo;
import com.oddfar.campus.huluwa.enums.PlatformEnum;
import com.oddfar.campus.huluwa.service.ICustomerService;
import com.oddfar.campus.huluwa.util.HuluwaHttpsUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    public CustomerServiceImpl() {
    }

    public CustomerInfo queryInfo(PlatformEnum platformEnum, String token) {
        String uri = "/front-manager/api/customer/queryById/token";
        String content = String.format("{\"channel\":\"h5\"}");
        return (CustomerInfo) HuluwaHttpsUtils.sendPostResult(platformEnum, uri, content, token, CustomerInfo.class);
    }
}