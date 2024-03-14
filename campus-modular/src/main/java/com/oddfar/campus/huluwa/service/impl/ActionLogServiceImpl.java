package com.oddfar.campus.huluwa.service.impl;

import com.oddfar.campus.common.domain.PageResult;
import com.oddfar.campus.huluwa.domain.ActionLogInfo;
import com.oddfar.campus.huluwa.entity.ActionLog;
import com.oddfar.campus.huluwa.entity.UserPlatform;
import com.oddfar.campus.huluwa.enums.PlatformEnum;
import com.oddfar.campus.huluwa.mapper.IActionLogMapper;
import com.oddfar.campus.huluwa.service.IActionLogService;
import com.oddfar.campus.huluwa.service.IUserPlatformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ActionLogServiceImpl implements IActionLogService {
    @Resource
    private IActionLogMapper actionLogMapper;
    @Resource
    private IUserPlatformService userPlatformService;

    public ActionLogServiceImpl() {
    }

    public int insert(ActionLog actionLog) {
        return this.actionLogMapper.insert(actionLog);
    }

    public PageResult<ActionLog> page(ActionLog actionLog) {
        return this.actionLogMapper.selectPage(actionLog);
    }

    public int insert(List<ActionLogInfo> list) {
        if (list != null && !list.isEmpty()) {
            int cnt = 0;

            ActionLogInfo info;
            for(Iterator var3 = list.iterator(); var3.hasNext(); cnt += this.insert(info.getPlatform(), info.getToken(), info.getMessage(), info.getStamp())) {
                info = (ActionLogInfo)var3.next();
            }

            return cnt;
        } else {
            return 0;
        }
    }

    public int insert(PlatformEnum platform, String token, String message, Date stamp) {
        UserPlatform userPlatform = this.userPlatformService.findByToken(token);
        ActionLog actionLog = new ActionLog();
        if (userPlatform != null) {
            actionLog.setPhone(userPlatform.getPhone());
        }

        actionLog.setPlatform(platform);
        actionLog.setMessage(message);
        if (stamp == null) {
            stamp = new Date();
        }

        actionLog.setStamp(stamp);
        return this.insert(actionLog);
    }
}