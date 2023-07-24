package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Dstudentgrade;

/**
 * 学生卫生Service接口
 * 
 * @author ruoyi
 * @date 2023-04-26
 */
public interface IDstudentgradeService 
{
    /**
     * 查询学生卫生
     * 
     * @param id 学生卫生主键
     * @return 学生卫生
     */
    public Dstudentgrade selectDstudentgradeById(String id);

    /**
     * 查询学生卫生列表
     * 
     * @param dstudentgrade 学生卫生
     * @return 学生卫生集合
     */
    public List<Dstudentgrade> selectDstudentgradeList(Dstudentgrade dstudentgrade);

    /**
     * 新增学生卫生
     * 
     * @param dstudentgrade 学生卫生
     * @return 结果
     */
    public int insertDstudentgrade(Dstudentgrade dstudentgrade);

    /**
     * 修改学生卫生
     * 
     * @param dstudentgrade 学生卫生
     * @return 结果
     */
    public int updateDstudentgrade(Dstudentgrade dstudentgrade);

    /**
     * 批量删除学生卫生
     * 
     * @param ids 需要删除的学生卫生主键集合
     * @return 结果
     */
    public int deleteDstudentgradeByIds(String ids);

    /**
     * 删除学生卫生信息
     * 
     * @param id 学生卫生主键
     * @return 结果
     */
    public int deleteDstudentgradeById(String id);
}
