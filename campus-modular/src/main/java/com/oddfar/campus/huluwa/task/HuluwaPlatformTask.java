package com.oddfar.campus.huluwa.task;

@EnableScheduling
@Component
public class HuluwaPlatformTask {
    private static final Logger log = LoggerFactory.getLogger(HuluwaPlatformTask.class);
    @Resource
    private IPlatformPromotionService platformPromotionService;

    public HuluwaPlatformTask() {
    }

    @Scheduled(
        cron = "4 39 */2 * * * "
    )
    public void refreshPlatform() {
        CommonUtils.sleepSeconds(120);

        try {
            this.platformPromotionService.refreshAll();
            log.info("刷新平台信息完成");
        } catch (Exception var2) {
            log.error("刷新平台信息出现异常", var2);
        }

    }
}
