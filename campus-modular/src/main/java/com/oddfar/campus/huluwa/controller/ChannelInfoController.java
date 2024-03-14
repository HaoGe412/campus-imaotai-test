package com.oddfar.campus.huluwa.controller;

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