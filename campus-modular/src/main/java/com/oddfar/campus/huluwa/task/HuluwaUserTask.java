package com.oddfar.campus.huluwa.task;

import com.oddfar.campus.huluwa.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@EnableScheduling
@Component
public class HuluwaUserTask {
    private static final Logger log = LoggerFactory.getLogger(HuluwaUserTask.class);
    @Resource
    private IUserPlatformService userPlatformService;

    public HuluwaUserTask() {
    }

    @Scheduled(
        cron = "42 6 */8 * * * "
    )
    public void refreshUser() {
        CommonUtils.sleepSeconds(120);

        try {
            log.info("开始刷新所有用户信息");
            int cnt = this.userPlatformService.refreshAllUserPlatform();
            log.info("成功刷新用户信息数量：{}", cnt);
        } catch (Exception var2) {
            log.error("刷新所有用户的信息出现异常", var2);
        }

    }
}