package com.oddfar.campus.huluwa.controller;

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