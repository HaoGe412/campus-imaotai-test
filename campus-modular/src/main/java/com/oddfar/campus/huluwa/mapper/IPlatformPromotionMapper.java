package com.oddfar.campus.huluwa.mapper;

import java.util.concurrent.TimeUnit;
import com.oddfar.campus.common.core.BaseMapperX;
import com.oddfar.campus.common.core.LambdaQueryWrapperX;
import com.oddfar.campus.common.domain.PageResult;
import com.oddfar.campus.huluwa.entity.PlatformPromotion;

import java.sql.Wrapper;
import java.util.List;

public interface IPlatformPromotionMapper extends BaseMapperX<PlatformPromotion> {
    default PageResult<PlatformPromotion> selectPage(PlatformPromotion entity) {
        return this.selectPage((new LambdaQueryWrapperX<PlatformPromotion>()).eqIfPresent(PlatformPromotion::getActivityId, entity.getActivityId()).eqIfPresent(PlatformPromotion::getPlatform, entity.getPlatform()).orderByDesc(PlatformPromotion::getPlatform));
    }

    default List<PlatformPromotion> selectForAppoint(long stamp) {
        return this.selectList((((new LambdaQueryWrapperX<PlatformPromotion>()).le(PlatformPromotion::getAppointStartTime, stamp)).ge(PlatformPromotion::getAppointEndTime, stamp)).orderByDesc(PlatformPromotion::getPlatform));
    }

    default List<PlatformPromotion> selectForDraw(long stamp) {
        return this.selectList((((new LambdaQueryWrapperX<PlatformPromotion>()).le(PlatformPromotion::getDrawTime, stamp)).ge(PlatformPromotion::getDrawTime, stamp - TimeUnit.HOURS.toMillis(1L))).orderByDesc(PlatformPromotion::getPlatform));
    }
}