package com.oddfar.campus.huluwa.controller;

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