package com.oddfar.campus.huluwa.controller;

import com.oddfar.campus.common.domain.R;
import com.oddfar.campus.huluwa.enums.PlatformEnum;
import com.oddfar.campus.huluwa.service.IChannelInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping({"/huluwa/channel-info"})
public class ChannelInfoController {
    @Resource
    private IChannelInfoService channelInfoService;

    public ChannelInfoController() {
    }

    @GetMapping({"/id"})
    public R channelId(PlatformEnum platformEnum, String token) {
        return R.ok(this.channelInfoService.getChannelId(platformEnum, token));
    }
}