package com.oddfar.campus.huluwa.service.impl;

import com.oddfar.campus.common.utils.StringUtils;
import com.oddfar.campus.huluwa.entity.PlatformPromotion;
import com.oddfar.campus.huluwa.entity.UserPlatform;
import com.oddfar.campus.huluwa.service.IPlatformPromotionService;
import com.oddfar.campus.huluwa.service.IPromotionService;
import com.oddfar.campus.huluwa.service.IUserPlatformService;
import com.oddfar.campus.huluwa.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Service
public class PromotionServiceImpl implements IPromotionService {
    private static final Logger log = LoggerFactory.getLogger(PromotionServiceImpl.class);
    @Resource
    private IPlatformPromotionService platformPromotionService;
    @Resource
    private IUserPlatformService userPlatformService;

    public PromotionServiceImpl() {
    }

    public int appointAll() {
        this.platformPromotionService.refreshAll();
        long current = System.currentTimeMillis();
        log.info("当前时间戳：{}", current);
        List<PlatformPromotion> appointPlatformList = this.platformPromotionService.selectByAppointTime(current);
        log.info("可预约的平台个数：{}", appointPlatformList.size());
        int cnt = 0;
        Iterator var5 = appointPlatformList.iterator();

        while(var5.hasNext()) {
            PlatformPromotion platformPromotion = (PlatformPromotion)var5.next();
            List<UserPlatform> userPlatformList = this.userPlatformService.queryByPlatform(platformPromotion.getPlatform());
            log.info("[{}]可预约的用户数量：{}", platformPromotion.getPlatformName(), userPlatformList.size());
            Iterator var8 = userPlatformList.iterator();

            while(var8.hasNext()) {
                UserPlatform userPlatform = (UserPlatform)var8.next();
                if (StringUtils.isBlank(userPlatform.getToken())) {
                    log.error("[{}]用户未配置token：{}", userPlatform.getPlatformName(), userPlatform);
                } else {
                    boolean result = this.userPlatformService.appoint(userPlatform.getPlatform(), userPlatform.getToken());
                    if (result) {
                        ++cnt;
                    }

                    CommonUtils.sleepMicroSeconds(900);
                }
            }

            CommonUtils.sleepMicroSeconds(800);
        }

        return cnt;
    }

    public int checkDraw() {
        this.platformPromotionService.refreshAll();
        long current = System.currentTimeMillis();
        log.info("当前时间戳：{}", current);
        List<PlatformPromotion> appointPlatformList = this.platformPromotionService.selectByDrawTime(current);
        int cnt = 0;
        Iterator var5 = appointPlatformList.iterator();

        while(var5.hasNext()) {
            PlatformPromotion platformPromotion = (PlatformPromotion)var5.next();
            List<UserPlatform> userPlatformList = this.userPlatformService.queryByPlatform(platformPromotion.getPlatform());
            log.info("[{}]可检查中签的用户数量：{}", platformPromotion.getPlatformName(), userPlatformList.size());
            Iterator var8 = userPlatformList.iterator();

            while(var8.hasNext()) {
                UserPlatform userPlatform = (UserPlatform)var8.next();
                if (StringUtils.isBlank(userPlatform.getToken())) {
                    log.error("[{}]用户未配置token：{}", userPlatform.getPlatformName(), userPlatform);
                } else {
                    boolean result = this.userPlatformService.checkDraw(userPlatform.getPlatform(), userPlatform.getToken());
                    if (result) {
                        ++cnt;
                    }

                    CommonUtils.sleepMicroSeconds(900);
                }
            }

            CommonUtils.sleepMicroSeconds(800);
        }

        return cnt;
    }
}
