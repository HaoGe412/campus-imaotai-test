package com.oddfar.campus.huluwa.mapper;

import com.oddfar.campus.common.core.BaseMapperX;
import com.oddfar.campus.common.core.LambdaQueryWrapperX;
import com.oddfar.campus.common.domain.PageResult;
import com.oddfar.campus.huluwa.entity.ActionLog;

public interface IActionLogMapper extends BaseMapperX<ActionLog> {
    default PageResult<ActionLog> selectPage(ActionLog actionLog) {
        return this.selectPage((new LambdaQueryWrapperX()).eqIfPresent(ActionLog::getPhone, actionLog.getPhone()).eqIfPresent(ActionLog::getPlatform, actionLog.getPlatform()).orderByDesc(ActionLog::getStamp));
    }
}
