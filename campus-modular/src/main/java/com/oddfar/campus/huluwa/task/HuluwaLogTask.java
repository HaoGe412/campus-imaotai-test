package com.oddfar.campus.huluwa.task;

@EnableScheduling
@Component
public class HuluwaLogTask {
    private static final Logger log = LoggerFactory.getLogger(HuluwaLogTask.class);
    @Resource
    private IRequestLogService requestLogService;
    @Resource
    private IActionLogService actionLogService;

    public HuluwaLogTask() {
    }

    @Scheduled(
        cron = "*/5 * * * * * "
    )
    public void dealLog() {
        List<RequestLog> list = HuluwaLogRepository.popAll();
        if (!list.isEmpty()) {
            try {
                Iterator var2 = list.iterator();

                while(var2.hasNext()) {
                    RequestLog requestLog = (RequestLog)var2.next();
                    this.requestLogService.insert(requestLog);
                }
            } catch (Exception var5) {
                log.error("写入请求日志出现异常", var5);
            }
        }

        List<ActionLogInfo> actionLogList = HuluwaLogRepository.popAllActionLog();
        if (!actionLogList.isEmpty()) {
            try {
                this.actionLogService.insert(actionLogList);
            } catch (Exception var4) {
                log.error("写入操作日志出现异常", var4);
            }
        }

    }
}