package com.oddfar.campus.huluwa.controller;

import com.oddfar.campus.common.domain.R;
import com.oddfar.campus.huluwa.enums.PlatformEnum;
import com.oddfar.campus.huluwa.service.ICustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping({"/huluwa/customer"})
public class CustomerController {
    @Resource
    private ICustomerService customerService;

    public CustomerController() {
    }

    @GetMapping({"/info"})
    public R info(PlatformEnum platformEnum, String token) {
        return R.ok(this.customerService.queryInfo(platformEnum, token));
    }
}
