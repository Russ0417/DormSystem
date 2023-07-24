package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 访客信息对象 dvisitor
 *
 * @author ruoyi
 * @date 2023-04-25
 */
public class Dvisitor extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 访客名称
     */
    @Excel(name = "访客名称")
    private String visitorName;

    /**
     * 访客身份
     */
    @Excel(name = "访客身份")
    private String visitorPosition;

    /**
     * 访问楼层
     */
    @Excel(name = "访问楼层")
    private String visitorBuilding;

    /**
     * 进入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "进入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date enterTime;

    /**
     * 离开时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离开时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date leaveTime;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorPosition(String visitorPosition) {
        this.visitorPosition = visitorPosition;
    }

    public String getVisitorPosition() {
        return visitorPosition;
    }

    public void setVisitorBuilding(String visitorBuilding) {
        this.visitorBuilding = visitorBuilding;
    }

    public String getVisitorBuilding() {
        return visitorBuilding;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("visitorName", getVisitorName())
                .append("visitorPosition", getVisitorPosition())
                .append("visitorBuilding", getVisitorBuilding())
                .append("enterTime", getEnterTime())
                .append("leaveTime", getLeaveTime())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
