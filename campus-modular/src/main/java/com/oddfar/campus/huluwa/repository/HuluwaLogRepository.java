package com.oddfar.campus.huluwa.repository;

import com.oddfar.campus.huluwa.domain.ActionLogInfo;
import com.oddfar.campus.huluwa.entity.RequestLog;
import com.oddfar.campus.huluwa.enums.PlatformEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HuluwaLogRepository {
    private static final List<RequestLog> LOG_LIST = new ArrayList();
    private static final List<ActionLogInfo> ACTION_LOG_LIST = new ArrayList();

    public HuluwaLogRepository() {
    }

    public static void cache(RequestLog requestLog) {
        synchronized (LOG_LIST) {
            LOG_LIST.add(requestLog);
        }
    }

    public static List<RequestLog> popAll() {
        List<RequestLog> list = new ArrayList();
        synchronized (LOG_LIST) {
            list.addAll(LOG_LIST);
            LOG_LIST.clear();
            return list;
        }
    }

    public static void cacheActionLog(PlatformEnum platform, String token, String message) {
        ActionLogInfo actionLogInfo = new ActionLogInfo();
        actionLogInfo.setPlatform(platform);
        actionLogInfo.setToken(token);
        actionLogInfo.setMessage(message);
        actionLogInfo.setStamp(new Date());
        synchronized (ACTION_LOG_LIST) {
            ACTION_LOG_LIST.add(actionLogInfo);
        }
    }

    public static List<ActionLogInfo> popAllActionLog() {
        List<ActionLogInfo> list = new ArrayList();
        synchronized (ACTION_LOG_LIST) {
            list.addAll(ACTION_LOG_LIST);
            ACTION_LOG_LIST.clear();
            return list;
        }
    }
}