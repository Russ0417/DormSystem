package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 班级信息对象 dclass
 *
 * @author ruoyi
 * @date 2023-04-25
 */
public class dClass extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    private String id;

    /**
     * 班级编号
     */
    @Excel(name = "班级编号")
    private String classId;

    /**
     * 班级名称
     */
    @Excel(name = "班级名称")
    private String className;

    /**
     * 班级年级
     */
    @Excel(name = "班级年级")
    private String classGrade;

    /**
     * 班级辅导员
     */
    @Excel(name = "班级辅导员")
    private String classTeacher;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("classId", getClassId())
                .append("className", getClassName())
                .append("classGrade", getClassGrade())
                .append("classTeacher", getClassTeacher())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
