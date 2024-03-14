package com.oddfar.campus.huluwa.service.impl;

import com.oddfar.campus.common.domain.PageResult;
import com.oddfar.campus.huluwa.domain.ChannelActivity;
import com.oddfar.campus.huluwa.entity.PlatformPromotion;
import com.oddfar.campus.huluwa.entity.PlatformPromotionHistory;
import com.oddfar.campus.huluwa.entity.UserPlatform;
import com.oddfar.campus.huluwa.enums.PlatformEnum;
import com.oddfar.campus.huluwa.mapper.IPlatformPromotionHistoryMapper;
import com.oddfar.campus.huluwa.mapper.IPlatformPromotionMapper;
import com.oddfar.campus.huluwa.repository.HuluwaLogRepository;
import com.oddfar.campus.huluwa.service.IPlatformPromotionService;
import com.oddfar.campus.huluwa.service.IPromotionActivityService;
import com.oddfar.campus.huluwa.service.IUserPlatformService;
import com.oddfar.campus.huluwa.util.CommonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class PlatformPromotionServiceImpl implements IPlatformPromotionService {
    @Resource
    private IPlatformPromotionMapper platformPromotionMapper;
    @Resource
    private IUserPlatformService userPlatformService;
    @Resource
    private IPlatformPromotionHistoryMapper platformPromotionHistoryMapper;
    @Resource
    private IPromotionActivityService promotionActivityService;

    public PlatformPromotionServiceImpl() {
    }

    public PlatformPromotion findByPlatform(PlatformEnum platformEnum) {
        return (PlatformPromotion)this.platformPromotionMapper.selectOne("platform", platformEnum);
    }

    public int refreshAll() {
        int cnt = 0;
        PlatformEnum[] var2 = PlatformEnum.values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            PlatformEnum platformEnum = var2[var4];
            boolean status = this.refreash(platformEnum);
            if (status) {
                ++cnt;
            }

            CommonUtils.sleepMicroSeconds(900);
        }

        return cnt;
    }

    public boolean refreash(PlatformEnum platformEnum) {
        List<UserPlatform> uList = this.userPlatformService.queryByPlatform(platformEnum);
        PlatformPromotion platformPromotion = new PlatformPromotion();
        platformPromotion.setPlatform(platformEnum);
        platformPromotion.setStamp(new Date());
        boolean status = false;
        if (uList != null && !uList.isEmpty()) {
            Iterator var5 = uList.iterator();

            while(var5.hasNext()) {
                UserPlatform up = (UserPlatform)var5.next();
                ChannelActivity channelActivity = this.promotionActivityService.queryChannelActivity(platformEnum, up.getToken());
                if (channelActivity.isSuccess()) {
                    platformPromotion.setActivityId(channelActivity.getId());
                    platformPromotion.setName(channelActivity.getName());
                    platformPromotion.setStartTime(channelActivity.getStartTime());
                    platformPromotion.setEndTime(channelActivity.getEndTime());
                    platformPromotion.setAppointStartTime(channelActivity.getAppointStartTime());
                    platformPromotion.setAppointEndTime(channelActivity.getAppointEndTime());
                    platformPromotion.setPurchaseStartTime(channelActivity.getPurchaseStartTime());
                    platformPromotion.setPurchaseEndTime(channelActivity.getPurchaseEndTime());
                    platformPromotion.setDrawTime(channelActivity.getDrawTime());
                    HuluwaLogRepository.cacheActionLog(platformEnum, up.getToken(), "成功刷新平台信息");
                    status = true;
                    break;
                }

                HuluwaLogRepository.cacheActionLog(platformEnum, up.getToken(), platformEnum.getDesc() + " 刷新失败：" + channelActivity.getMessage());
                CommonUtils.sleepMicroSeconds(800);
            }
        }

        this.createOrUpdate(platformPromotion);
        return status;
    }

    public PageResult<PlatformPromotion> page(PlatformPromotion platformPromotion) {
        return this.platformPromotionMapper.selectPage(platformPromotion);
    }

    private void createOrUpdate(PlatformPromotion platformPromotion) {
        PlatformPromotion dbPlatformPromotion = this.findByPlatform(platformPromotion.getPlatform());
        if (dbPlatformPromotion != null) {
            PlatformPromotionHistory history = new PlatformPromotionHistory();
            BeanUtils.copyProperties(dbPlatformPromotion, history);
            this.platformPromotionHistoryMapper.insert(history);
            this.platformPromotionMapper.deleteById(dbPlatformPromotion.getId());
        }

        this.insert(platformPromotion);
    }

    public int insert(PlatformPromotion platformPromotion) {
        return this.platformPromotionMapper.insert(platformPromotion);
    }

    public List<PlatformPromotion> selectByAppointTime(long stamp) {
        return this.platformPromotionMapper.selectForAppoint(stamp);
    }

    public List<PlatformPromotion> selectByDrawTime(long stamp) {
        return this.platformPromotionMapper.selectForDraw(stamp);
    }
}
