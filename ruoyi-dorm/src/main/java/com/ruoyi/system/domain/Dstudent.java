package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 学生信息对象 dstudent
 *
 * @author ruoyi
 * @date 2023-04-25
 */
public class Dstudent extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    private String id;

    /**
     * 学生编号
     */
    @Excel(name = "学生编号")
    private String studentId;

    /**
     * 学生姓名
     */
    @Excel(name = "学生姓名")
    private String studentName;

    /**
     * 学生性别
     */
    @Excel(name = "学生性别")
    private String studentSex;

    /**
     * 所属班级
     */
    @Excel(name = "所属班级")
    private String studentClass;

    /**
     * 所属年级
     */
    @Excel(name = "所属年级")
    private String studentGrade;

    /**
     * 宿舍编号
     */
    @Excel(name = "宿舍编号")
    private String studentDorm;

    /**
     * 所属楼层
     */
    @Excel(name = "所属楼层")
    private String studentBuild;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentDorm(String studentDorm) {
        this.studentDorm = studentDorm;
    }

    public String getStudentDorm() {
        return studentDorm;
    }

    public void setStudentBuild(String studentBuild) {
        this.studentBuild = studentBuild;
    }

    public String getStudentBuild() {
        return studentBuild;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("studentId", getStudentId())
                .append("studentName", getStudentName())
                .append("studentSex", getStudentSex())
                .append("studentClass", getStudentClass())
                .append("studentGrade", getStudentGrade())
                .append("studentDorm", getStudentDorm())
                .append("studentBuild", getStudentBuild())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
