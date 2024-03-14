package com.oddfar.campus.huluwa.service;

import com.oddfar.campus.common.domain.PageResult;
import com.oddfar.campus.huluwa.domain.ActionLogInfo;
import com.oddfar.campus.huluwa.entity.ActionLog;
import com.oddfar.campus.huluwa.enums.PlatformEnum;

import java.util.Date;
import java.util.List;

public interface IActionLogService {
    int insert(PlatformEnum var1, String var2, String var3, Date var4);

    int insert(List<ActionLogInfo> var1);

    int insert(ActionLog var1);

    PageResult<ActionLog> page(ActionLog var1);
}
