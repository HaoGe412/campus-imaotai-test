package com.oddfar.campus.huluwa.task;

import com.oddfar.campus.huluwa.domain.ActionLogInfo;
import com.oddfar.campus.huluwa.entity.RequestLog;
import com.oddfar.campus.huluwa.repository.HuluwaLogRepository;
import com.oddfar.campus.huluwa.service.IActionLogService;
import com.oddfar.campus.huluwa.service.IRequestLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

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