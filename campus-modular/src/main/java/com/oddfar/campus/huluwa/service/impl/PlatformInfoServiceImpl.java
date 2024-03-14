package com.oddfar.campus.huluwa.service.impl;

import com.oddfar.campus.huluwa.domain.PlatformInfo;
import com.oddfar.campus.huluwa.enums.PlatformEnum;
import com.oddfar.campus.huluwa.service.IPlatformInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatformInfoServiceImpl implements IPlatformInfoService {
    public PlatformInfoServiceImpl() {
    }

    public List<PlatformInfo> queryAll() {
        List<PlatformInfo> list = new ArrayList();
        PlatformEnum[] var2 = PlatformEnum.values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            PlatformEnum PlatformEnum = var2[var4];
            PlatformInfo platformInfo = new PlatformInfo();
            platformInfo.setPlatform(PlatformEnum.toString());
            platformInfo.setName(PlatformEnum.getDesc());
            list.add(platformInfo);
        }

        return list;
    }
}
