package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 维修信息对象 drepair
 *
 * @author ruoyi
 * @date 2023-04-25
 */
public class Drepair extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 修理楼层
     */
    @Excel(name = "修理楼层")
    private String repairBuild;

    /**
     * 修理宿舍
     */
    @Excel(name = "修理宿舍")
    private String repairDorm;

    /**
     * 申报人
     */
    @Excel(name = "申报人")
    private String reporter;

    /**
     * 修理物品
     */
    @Excel(name = "修理物品")
    private String repairThing;

    /**
     * 修理费用
     */
    @Excel(name = "修理费用")
    private String repairPay;

    /**
     * 修理原因
     */
    @Excel(name = "修理原因")
    private String repairReason;

    /**
     * 修理人
     */
    @Excel(name = "修理人")
    private String repairPerson;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setRepairBuild(String repairBuild) {
        this.repairBuild = repairBuild;
    }

    public String getRepairBuild() {
        return repairBuild;
    }

    public void setRepairDorm(String repairDorm) {
        this.repairDorm = repairDorm;
    }

    public String getRepairDorm() {
        return repairDorm;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReporter() {
        return reporter;
    }

    public void setRepairThing(String repairThing) {
        this.repairThing = repairThing;
    }

    public String getRepairThing() {
        return repairThing;
    }

    public void setRepairPay(String repairPay) {
        this.repairPay = repairPay;
    }

    public String getRepairPay() {
        return repairPay;
    }

    public void setRepairReason(String repairReason) {
        this.repairReason = repairReason;
    }

    public String getRepairReason() {
        return repairReason;
    }

    public void setRepairPerson(String repairPerson) {
        this.repairPerson = repairPerson;
    }

    public String getRepairPerson() {
        return repairPerson;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("repairBuild", getRepairBuild())
                .append("repairDorm", getRepairDorm())
                .append("reporter", getReporter())
                .append("repairThing", getRepairThing())
                .append("repairPay", getRepairPay())
                .append("repairReason", getRepairReason())
                .append("repairPerson", getRepairPerson())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
