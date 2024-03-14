package com.oddfar.campus.huluwa.controller;

import com.oddfar.campus.common.domain.R;
import com.oddfar.campus.huluwa.entity.PlatformPromotion;
import com.oddfar.campus.huluwa.enums.PlatformEnum;
import com.oddfar.campus.huluwa.service.IPlatformPromotionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping({"/huluwa/platform-promotion"})
public class PlatformPromotionController {
    @Resource
    private IPlatformPromotionService platformPromotionService;

    public PlatformPromotionController() {
    }

    @PutMapping({"/refresh-all"})
    public R refreshAll() {
        return R.ok(this.platformPromotionService.refreshAll());
    }

    @GetMapping({"/refresh"})
    public R refresh(@RequestParam PlatformEnum platformEnum) {
        return R.ok(this.platformPromotionService.refreash(platformEnum));
    }

    @GetMapping({"/page"})
    public R page(PlatformPromotion entity) {
        return R.ok().put(this.platformPromotionService.page(entity));
    }
}