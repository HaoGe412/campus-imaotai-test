package com.oddfar.campus.huluwa.controller;

import com.oddfar.campus.common.domain.R;
import com.oddfar.campus.huluwa.domain.BaseParam;
import com.oddfar.campus.huluwa.entity.UserPlatform;
import com.oddfar.campus.huluwa.enums.PlatformEnum;
import com.oddfar.campus.huluwa.service.IUserPlatformService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping({"/huluwa/user-platform"})
public class UserPlatformController {
    @Resource
    private IUserPlatformService userPlatformService;

    public UserPlatformController() {
    }

    @GetMapping({"/page"})
    public R page(UserPlatform userPlatform) {
        return R.ok().put(this.userPlatformService.page(userPlatform));
    }

    @PostMapping({"/add"})
    public R add(@RequestBody BaseParam baseParam) {
        return R.ok(this.userPlatformService.addUserPlatform(baseParam.getPlatform(), baseParam.getToken()));
    }

    @DeleteMapping({"/id/{id}"})
    public R add(@PathVariable("id") Long id) {
        return R.ok(this.userPlatformService.delete(id));
    }

    @PutMapping({"/refresh"})
    public R refresh(@RequestBody BaseParam baseParam) {
        return R.ok(this.userPlatformService.refreshUserPlatform(baseParam.getPlatform(), baseParam.getToken()));
    }

    @GetMapping({"/appoint"})
    public R appoint(PlatformEnum platformEnum, String token) {
        return R.ok(this.userPlatformService.appoint(platformEnum, token));
    }
}