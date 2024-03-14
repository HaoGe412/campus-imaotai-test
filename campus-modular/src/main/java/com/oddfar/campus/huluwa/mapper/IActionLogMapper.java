//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.oddfar.campus.huluwa.mapper;

import com.oddfar.campus.common.core.BaseMapperX;
import com.oddfar.campus.common.core.LambdaQueryWrapperX;
import com.oddfar.campus.common.domain.PageResult;
import com.oddfar.campus.huluwa.entity.ActionLog;

public interface IActionLogMapper extends BaseMapperX<ActionLog> {
    default PageResult<ActionLog> selectPage(ActionLog actionLog) {
        return this.selectPage((new LambdaQueryWrapperX<ActionLog>()).eqIfPresent(ActionLog::getPhone, actionLog.getPhone()).eqIfPresent(ActionLog::getPlatform, actionLog.getPlatform()).orderByDesc(ActionLog::getStamp));
    }
}
