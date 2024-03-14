package com.oddfar.campus.huluwa.service;

import com.oddfar.campus.common.domain.PageResult;
import com.oddfar.campus.huluwa.entity.PlatformPromotion;
import com.oddfar.campus.huluwa.enums.PlatformEnum;

import java.util.List;

public interface IPlatformPromotionService {
    int insert(PlatformPromotion var1);

    PlatformPromotion findByPlatform(PlatformEnum var1);

    int refreshAll();

    boolean refreash(PlatformEnum var1);

    PageResult<PlatformPromotion> page(PlatformPromotion var1);

    List<PlatformPromotion> selectByAppointTime(long var1);

    List<PlatformPromotion> selectByDrawTime(long var1);
}
