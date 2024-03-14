package com.oddfar.campus.huluwa.service.impl;

import com.oddfar.campus.huluwa.entity.RequestLog;
import com.oddfar.campus.huluwa.mapper.IRequestLogMapper;
import com.oddfar.campus.huluwa.service.IRequestLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RequestLogServiceImpl implements IRequestLogService {
    @Resource
    private IRequestLogMapper requestLogMapper;

    public RequestLogServiceImpl() {
    }

    public int insert(RequestLog requestLog) {
        return this.requestLogMapper.insert(requestLog);
    }
}
