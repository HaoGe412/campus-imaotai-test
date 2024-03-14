package com.oddfar.campus.huluwa.service;

import com.oddfar.campus.huluwa.domain.ChannelInfo;
import com.oddfar.campus.huluwa.enums.PlatformEnum;

public interface IChannelInfoService {
    Integer getChannelId(PlatformEnum var1, String var2);

    ChannelInfo getChannelInfo(PlatformEnum var1, String var2);
}
