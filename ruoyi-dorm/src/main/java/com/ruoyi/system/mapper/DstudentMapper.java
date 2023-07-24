package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Dstudent;

import java.util.List;

/**
 * 学生信息Mapper接口
 *
 * @author ruoyi
 * @date 2023-04-25
 */
public interface DstudentMapper {
    /**
     * 查询学生信息
     *
     * @param id 学生信息主键
     * @return 学生信息
     */
    public Dstudent selectDstudentById(String id);

    /**
     * 查询学生信息列表
     *
     * @param dstudent 学生信息
     * @return 学生信息集合
     */
    public List<Dstudent> selectDstudentList(Dstudent dstudent);

    /**
     * 新增学生信息
     *
     * @param dstudent 学生信息
     * @return 结果
     */
    public int insertDstudent(Dstudent dstudent);

    /**
     * 修改学生信息
     *
     * @param dstudent 学生信息
     * @return 结果
     */
    public int updateDstudent(Dstudent dstudent);

    /**
     * 删除学生信息
     *
     * @param id 学生信息主键
     * @return 结果
     */
    public int deleteDstudentById(String id);

    /**
     * 批量删除学生信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDstudentByIds(String[] ids);

    List<Dstudent> selectStudentByClassId(String classId);
}
