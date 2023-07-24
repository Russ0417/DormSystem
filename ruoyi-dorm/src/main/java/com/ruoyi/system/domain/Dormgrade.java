package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍卫生对象 dormgrade
 * 
 * @author ruoyi
 * @date 2023-04-26
 */
public class Dormgrade extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private String id;

    /** 宿舍编号 */
    @Excel(name = "宿舍编号")
    private String dormId;

    /** 所属楼层 */
    @Excel(name = "所属楼层")
    private String dormBuilding;

    /** 卫生评级 */
    @Excel(name = "卫生评级")
    private String dormGrade;

    /** 填报人 */
    @Excel(name = "填报人")
    private String reporter;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setDormId(String dormId) 
    {
        this.dormId = dormId;
    }

    public String getDormId() 
    {
        return dormId;
    }
    public void setDormBuilding(String dormBuilding) 
    {
        this.dormBuilding = dormBuilding;
    }

    public String getDormBuilding() 
    {
        return dormBuilding;
    }
    public void setDormGrade(String dormGrade) 
    {
        this.dormGrade = dormGrade;
    }

    public String getDormGrade() 
    {
        return dormGrade;
    }
    public void setReporter(String reporter) 
    {
        this.reporter = reporter;
    }

    public String getReporter() 
    {
        return reporter;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dormId", getDormId())
            .append("dormBuilding", getDormBuilding())
            .append("dormGrade", getDormGrade())
            .append("reporter", getReporter())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
