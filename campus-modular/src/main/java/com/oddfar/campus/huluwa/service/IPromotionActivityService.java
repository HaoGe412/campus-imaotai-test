package com.oddfar.campus.huluwa.service;

import com.oddfar.campus.huluwa.domain.ChannelActivity;
import com.oddfar.campus.huluwa.enums.PlatformEnum;

public interface IPromotionActivityService {
    ChannelActivity queryChannelActivity(PlatformEnum var1, String var2);

    boolean checkCustomerInQianggou(PlatformEnum var1, String var2, int var3);

    boolean queryActivityIsDraw(PlatformEnum var1, String var2, int var3);

    boolean appoint(PlatformEnum var1, String var2, int var3, int var4);
}
