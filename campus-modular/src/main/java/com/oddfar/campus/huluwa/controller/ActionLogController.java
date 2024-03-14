package com.oddfar.campus.huluwa.controller;

import com.oddfar.campus.common.domain.R;
import com.oddfar.campus.huluwa.entity.ActionLog;
import com.oddfar.campus.huluwa.service.IActionLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ActionLogController
 * @Description TODO
 * @Author kgy0809@163.com
 * @Date 2024-03-14 14:08
 * @Version 1.0
 **/
@RestController
@RequestMapping({"/huluwa/action-log"})
public class ActionLogController {
    @Resource
    private IActionLogService actionLogService;

    public ActionLogController() {
    }

    @GetMapping({"/page"})
    public R page(ActionLog entity) {
        return R.ok().put(this.actionLogService.page(entity));
    }
}
