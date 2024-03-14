package com.oddfar.campus.huluwa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oddfar.campus.common.utils.DateUtils;
import com.oddfar.campus.huluwa.enums.PlatformEnum;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName ActionLog
 * @Description TODO
 * @Author kgy0809@163.com
 * @Date 2024-03-14 14:14
 * @Version 1.0
 **/
@Data
@TableName("action_log")
public class ActionLog {

    private static final Integer PAGE_NUM = 1;
    private static final Integer PAGE_SIZE = 10;
    @TableId
    private Long id;
    private String phone;
    private PlatformEnum platform;
    private String message;
    private Date stamp;
    @TableField(
            exist = false
    )
    @JsonIgnore
    private @NotNull(
            message = "页码不能为空"
    ) @Min(
            value = 1L,
            message = "页码最小值为 1"
    ) Integer pageNum;
    @TableField(
            exist = false
    )
    @JsonIgnore
    private @NotNull(
            message = "每页条数不能为空"
    ) @Min(
            value = 1L,
            message = "每页条数最小值为 1"
    ) @Max(
            value = 100L,
            message = "每页条数最大值为 100"
    ) Integer pageSize;

    public String getPlatformName() {
        return this.platform == null ? null : this.platform.getDesc();
    }

    public String getStampFmt() {
        return this.stamp == null ? null : DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, this.stamp);
    }

    public ActionLog() {
        this.pageNum = PAGE_NUM;
        this.pageSize = PAGE_SIZE;
    }

}
