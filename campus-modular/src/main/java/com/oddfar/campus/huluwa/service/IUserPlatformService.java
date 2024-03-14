package com.oddfar.campus.huluwa.service;

import com.oddfar.campus.common.domain.PageResult;
import com.oddfar.campus.huluwa.domain.CustomerInfoDto;
import com.oddfar.campus.huluwa.entity.UserPlatform;
import com.oddfar.campus.huluwa.enums.PlatformEnum;

import java.util.List;

public interface IUserPlatformService {
    int insert(UserPlatform var1);

    UserPlatform findByToken(String var1);

    UserPlatform findUniqueUser(PlatformEnum var1, String var2);

    List<UserPlatform> queryAll();

    List<UserPlatform> queryByPlatform(PlatformEnum var1);

    PageResult<UserPlatform> page(UserPlatform var1);

    CustomerInfoDto addUserPlatform(PlatformEnum var1, String var2);

    boolean refreshUserPlatform(PlatformEnum var1, String var2);

    int refreshAllUserPlatform();

    int delete(Long var1);

    boolean appoint(PlatformEnum var1, String var2);

    boolean checkDraw(PlatformEnum var1, String var2);
}
