package com.oddfar.campus.huluwa.controller;

import com.oddfar.campus.common.domain.R;
import com.oddfar.campus.huluwa.service.IPlatformInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping({"/huluwa/platform-info"})
public class PlatformInfoController {
    @Resource
    private IPlatformInfoService platformInfoService;

    public PlatformInfoController() {
    }

    @GetMapping({"/all"})
    public R all() {
        return R.ok(this.platformInfoService.queryAll());
    }
}