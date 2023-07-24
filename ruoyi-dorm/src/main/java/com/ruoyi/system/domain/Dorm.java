package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 宿舍信息对象 dorm
 *
 * @author ruoyi
 * @date 2023-04-25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Dorm extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 宿舍编号
     */
    @Excel(name = "宿舍编号")
    private Long dormId;

    /**
     * 宿舍名称
     */
    @Excel(name = "宿舍名称")
    private String dormName;

    /**
     * 宿舍楼号
     */
    @Excel(name = "宿舍楼号")
    private String dbuilding;

    /**
     * 宿舍类型(单人，双人，四人，六人)
     */
    @Excel(name = "宿舍类型(单人，双人，四人，六人)")
    private String dtype;

    /**
     * 住宿费用
     */
    @Excel(name = "住宿费用")
    private Long dormPay;

    /**
     * 电费
     */
    @Excel(name = "电费")
    private Long electricPay;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setDormId(Long dormId) {
        this.dormId = dormId;
    }

    public Long getDormId() {
        return dormId;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDbuilding(String dbuilding) {
        this.dbuilding = dbuilding;
    }

    public String getDbuilding() {
        return dbuilding;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDormPay(Long dormPay) {
        this.dormPay = dormPay;
    }

    public Long getDormPay() {
        return dormPay;
    }

    public void setElectricPay(Long electricPay) {
        this.electricPay = electricPay;
    }

    public Long getElectricPay() {
        return electricPay;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("dormId", getDormId())
                .append("dormName", getDormName())
                .append("dbuilding", getDbuilding())
                .append("dtype", getDtype())
                .append("dormPay", getDormPay())
                .append("electricPay", getElectricPay())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
