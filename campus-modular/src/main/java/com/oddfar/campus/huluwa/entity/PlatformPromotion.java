package com.oddfar.campus.huluwa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oddfar.campus.common.utils.DateUtils;
import com.oddfar.campus.huluwa.enums.PlatformEnum;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PlatformPromotion)) {
            return false;
        } else {
            PlatformPromotion other = (PlatformPromotion)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$activityId = this.getActivityId();
                Object other$activityId = other.getActivityId();
                if (this$activityId == null) {
                    if (other$activityId != null) {
                        return false;
                    }
                } else if (!this$activityId.equals(other$activityId)) {
                    return false;
                }

                Object this$startTime = this.getStartTime();
                Object other$startTime = other.getStartTime();
                if (this$startTime == null) {
                    if (other$startTime != null) {
                        return false;
                    }
                } else if (!this$startTime.equals(other$startTime)) {
                    return false;
                }

                label158: {
                    Object this$endTime = this.getEndTime();
                    Object other$endTime = other.getEndTime();
                    if (this$endTime == null) {
                        if (other$endTime == null) {
                            break label158;
                        }
                    } else if (this$endTime.equals(other$endTime)) {
                        break label158;
                    }

                    return false;
                }

                label151: {
                    Object this$appointStartTime = this.getAppointStartTime();
                    Object other$appointStartTime = other.getAppointStartTime();
                    if (this$appointStartTime == null) {
                        if (other$appointStartTime == null) {
                            break label151;
                        }
                    } else if (this$appointStartTime.equals(other$appointStartTime)) {
                        break label151;
                    }

                    return false;
                }

                Object this$appointEndTime = this.getAppointEndTime();
                Object other$appointEndTime = other.getAppointEndTime();
                if (this$appointEndTime == null) {
                    if (other$appointEndTime != null) {
                        return false;
                    }
                } else if (!this$appointEndTime.equals(other$appointEndTime)) {
                    return false;
                }

                label137: {
                    Object this$purchaseStartTime = this.getPurchaseStartTime();
                    Object other$purchaseStartTime = other.getPurchaseStartTime();
                    if (this$purchaseStartTime == null) {
                        if (other$purchaseStartTime == null) {
                            break label137;
                        }
                    } else if (this$purchaseStartTime.equals(other$purchaseStartTime)) {
                        break label137;
                    }

                    return false;
                }

                label130: {
                    Object this$purchaseEndTime = this.getPurchaseEndTime();
                    Object other$purchaseEndTime = other.getPurchaseEndTime();
                    if (this$purchaseEndTime == null) {
                        if (other$purchaseEndTime == null) {
                            break label130;
                        }
                    } else if (this$purchaseEndTime.equals(other$purchaseEndTime)) {
                        break label130;
                    }

                    return false;
                }

                Object this$drawTime = this.getDrawTime();
                Object other$drawTime = other.getDrawTime();
                if (this$drawTime == null) {
                    if (other$drawTime != null) {
                        return false;
                    }
                } else if (!this$drawTime.equals(other$drawTime)) {
                    return false;
                }

                Object this$pageNum = this.getPageNum();
                Object other$pageNum = other.getPageNum();
                if (this$pageNum == null) {
                    if (other$pageNum != null) {
                        return false;
                    }
                } else if (!this$pageNum.equals(other$pageNum)) {
                    return false;
                }

                label109: {
                    Object this$pageSize = this.getPageSize();
                    Object other$pageSize = other.getPageSize();
                    if (this$pageSize == null) {
                        if (other$pageSize == null) {
                            break label109;
                        }
                    } else if (this$pageSize.equals(other$pageSize)) {
                        break label109;
                    }

                    return false;
                }

                label102: {
                    Object this$platform = this.getPlatform();
                    Object other$platform = other.getPlatform();
                    if (this$platform == null) {
                        if (other$platform == null) {
                            break label102;
                        }
                    } else if (this$platform.equals(other$platform)) {
                        break label102;
                    }

                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$stamp = this.getStamp();
                Object other$stamp = other.getStamp();
                if (this$stamp == null) {
                    if (other$stamp != null) {
                        return false;
                    }
                } else if (!this$stamp.equals(other$stamp)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PlatformPromotion;
    }

    public int hashCode() {
//        int PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $activityId = this.getActivityId();
        result = result * 59 + ($activityId == null ? 43 : $activityId.hashCode());
        Object $startTime = this.getStartTime();
        result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
        Object $endTime = this.getEndTime();
        result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
        Object $appointStartTime = this.getAppointStartTime();
        result = result * 59 + ($appointStartTime == null ? 43 : $appointStartTime.hashCode());
        Object $appointEndTime = this.getAppointEndTime();
        result = result * 59 + ($appointEndTime == null ? 43 : $appointEndTime.hashCode());
        Object $purchaseStartTime = this.getPurchaseStartTime();
        result = result * 59 + ($purchaseStartTime == null ? 43 : $purchaseStartTime.hashCode());
        Object $purchaseEndTime = this.getPurchaseEndTime();
        result = result * 59 + ($purchaseEndTime == null ? 43 : $purchaseEndTime.hashCode());
        Object $drawTime = this.getDrawTime();
        result = result * 59 + ($drawTime == null ? 43 : $drawTime.hashCode());
        Object $pageNum = this.getPageNum();
        result = result * 59 + ($pageNum == null ? 43 : $pageNum.hashCode());
        Object $pageSize = this.getPageSize();
        result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
        Object $platform = this.getPlatform();
        result = result * 59 + ($platform == null ? 43 : $platform.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $stamp = this.getStamp();
        result = result * 59 + ($stamp == null ? 43 : $stamp.hashCode());
        return result;
    }

    public String toString() {
        return "PlatformPromotion(id=" + this.getId() + ", platform=" + this.getPlatform() + ", activityId=" + this.getActivityId() + ", name=" + this.getName() + ", startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ", appointStartTime=" + this.getAppointStartTime() + ", appointEndTime=" + this.getAppointEndTime() + ", purchaseStartTime=" + this.getPurchaseStartTime() + ", purchaseEndTime=" + this.getPurchaseEndTime() + ", drawTime=" + this.getDrawTime() + ", stamp=" + this.getStamp() + ", pageNum=" + this.getPageNum() + ", pageSize=" + this.getPageSize() + ")";
    }
}
