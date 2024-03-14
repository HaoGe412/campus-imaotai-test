package com.oddfar.campus.huluwa.service.impl;

import com.oddfar.campus.huluwa.domain.ChannelActivity;
import com.oddfar.campus.huluwa.domain.HuluwaResponse;
import com.oddfar.campus.huluwa.enums.PlatformEnum;
import com.oddfar.campus.huluwa.repository.HuluwaLogRepository;
import com.oddfar.campus.huluwa.service.IActionLogService;
import com.oddfar.campus.huluwa.service.IPromotionActivityService;
import com.oddfar.campus.huluwa.util.HuluwaHttpsUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PromotionActivityServiceImpl implements IPromotionActivityService {
    @Resource
    private IActionLogService actionLogService;

    public PromotionActivityServiceImpl() {
    }

    public ChannelActivity queryChannelActivity(PlatformEnum platformEnum, String token) {
        String uri = "/front-manager/api/customer/promotion/channelActivity";
        String content = String.format("{}");
        return (ChannelActivity) HuluwaHttpsUtils.sendPostResult(platformEnum, uri, content, token, ChannelActivity.class);
    }

    public boolean checkCustomerInQianggou(PlatformEnum platformEnum, String token, int activityId) {
        String uri = "/front-manager/api/customer/promotion/checkCustomerInQianggou";
        String content = String.format("{\"activityId\":%d}", activityId);
        HuluwaResponse response = HuluwaHttpsUtils.sendPost(platformEnum, uri, content, token);
        if (response == null) {
            HuluwaLogRepository.cacheActionLog(platformEnum, token, "查询预约结果失败：请求失败");
            return false;
        } else {
            HuluwaLogRepository.cacheActionLog(platformEnum, token, "用户预约状态：" + response.getMessage());
            return "true".equals(response.getData());
        }
    }

    public boolean queryActivityIsDraw(PlatformEnum platformEnum, String token, int activityId) {
        String uri = "/front-manager/api/customer/promotion/queryActivityIsDraw";
        String content = String.format("{\"id\":%d}", activityId);
        HuluwaResponse response = HuluwaHttpsUtils.sendPost(platformEnum, uri, content, token);
        if (response == null) {
            HuluwaLogRepository.cacheActionLog(platformEnum, token, "查询摇号结果失败：请求失败");
            return false;
        } else if (!response.isSuccess()) {
            HuluwaLogRepository.cacheActionLog(platformEnum, token, response.getMessage());
            return false;
        } else {
            HuluwaLogRepository.cacheActionLog(platformEnum, token, "用户已经中签！！！");
            return true;
        }
    }

    public boolean appoint(PlatformEnum platformEnum, String token, int activityId, int channelId) {
        String uri = "/front-manager/api/customer/promotion/appoint";
        String content = String.format("{\"activityId\":%d,\"channelId\":%d}", activityId, channelId);
        HuluwaResponse response = HuluwaHttpsUtils.sendPost(platformEnum, uri, content, token);
        if (response == null) {
            HuluwaLogRepository.cacheActionLog(platformEnum, token, "预约失败：请求失败");
            return false;
        } else if (!response.isSuccess()) {
            HuluwaLogRepository.cacheActionLog(platformEnum, token, "预约结果：" + response.getMessage());
            return false;
        } else {
            HuluwaLogRepository.cacheActionLog(platformEnum, token, "预约成功！！！");
            return true;
        }
    }
}
