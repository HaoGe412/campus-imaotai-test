package com.oddfar.campus.huluwa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oddfar.campus.common.utils.DateUtils;
import com.oddfar.campus.huluwa.enums.PlatformEnum;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName PlatformPromotion
 * @Description TODO
 * @Author kgy0809@163.com
 * @Date 2024-03-14 14:15
 * @Version 1.0
 **/
public class PlatformPromotion {
    private static final Integer PAGE_NUM = 1;
    private static final Integer PAGE_SIZE = 10;
    @TableId
    private Long id;
    private PlatformEnum platform;
    private Integer activityId;
    private String name;
    private Long startTime;
    private Long endTime;
    private Long appointStartTime;
    private Long appointEndTime;
    private Long purchaseStartTime;
    private Long purchaseEndTime;
    private Long drawTime;
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

    public String getStartTimeFmt() {
        return DateUtils.parseStampToStr(DateUtils.MM_DD_HH_MM_SS, this.startTime);
    }

    public String getEndTimeFmt() {
        return DateUtils.parseStampToStr(DateUtils.MM_DD_HH_MM_SS, this.endTime);
    }

    public String getAppointStartTimeFmt() {
        return DateUtils.parseStampToStr(DateUtils.MM_DD_HH_MM_SS, this.appointStartTime);
    }

    public String getAppointEndTimeFmt() {
        return DateUtils.parseStampToStr(DateUtils.MM_DD_HH_MM_SS, this.appointEndTime);
    }

    public String getPurchaseStartTimeFmt() {
        return DateUtils.parseStampToStr(DateUtils.MM_DD_HH_MM_SS, this.purchaseStartTime);
    }

    public String getPurchaseEndTimeFmt() {
        return DateUtils.parseStampToStr(DateUtils.MM_DD_HH_MM_SS, this.purchaseEndTime);
    }

    public String getDrawTimeFmt() {
        return DateUtils.parseStampToStr(DateUtils.MM_DD_HH_MM_SS, this.drawTime);
    }

    public String getStampFmt() {
        return this.stamp == null ? null : DateUtils.parseDateToStr(DateUtils.MM_DD_HH_MM_SS, this.stamp);
    }

    public PlatformPromotion() {
        this.pageNum = PAGE_NUM;
        this.pageSize = PAGE_SIZE;
    }

    public Long getId() {
        return this.id;
    }

    public PlatformEnum getPlatform() {
        return this.platform;
    }

    public Integer getActivityId() {
        return this.activityId;
    }

    public String getName() {
        return this.name;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public Long getAppointStartTime() {
        return this.appointStartTime;
    }

    public Long getAppointEndTime() {
        return this.appointEndTime;
    }

    public Long getPurchaseStartTime() {
        return this.purchaseStartTime;
    }

    public Long getPurchaseEndTime() {
        return this.purchaseEndTime;
    }

    public Long getDrawTime() {
        return this.drawTime;
    }

    public Date getStamp() {
        return this.stamp;
    }

    public Integer getPageNum() {
        return this.pageNum;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlatform(PlatformEnum platform) {
        this.platform = platform;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public void setAppointStartTime(Long appointStartTime) {
        this.appointStartTime = appointStartTime;
    }

    public void setAppointEndTime(Long appointEndTime) {
        this.appointEndTime = appointEndTime;
    }

    public void setPurchaseStartTime(Long purchaseStartTime) {
        this.purchaseStartTime = purchaseStartTime;
    }

    public void setPurchaseEndTime(Long purchaseEndTime) {
        this.purchaseEndTime = purchaseEndTime;
    }

    public void setDrawTime(Long drawTime) {
        this.drawTime = drawTime;
    }

    public void setStamp(Date stamp) {
        this.stamp = stamp;
    }

    @JsonIgnore
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @JsonIgnore
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
