package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.dClass;

import java.util.List;

/**
 * 班级信息Mapper接口
 *
 * @author ruoyi
 * @date 2023-04-25
 */
public interface dClassMapper {
    /**
     * 查询班级信息
     *
     * @param id 班级信息主键
     * @return 班级信息
     */
    public dClass selectdClassById(String id);

    /**
     * 查询班级信息列表
     *
     * @param dClass 班级信息
     * @return 班级信息集合
     */
    public List<dClass> selectdClassList(dClass dClass);

    /**
     * 新增班级信息
     *
     * @param dClass 班级信息
     * @return 结果
     */
    public int insertdClass(dClass dClass);

    /**
     * 修改班级信息
     *
     * @param dClass 班级信息
     * @return 结果
     */
    public int updatedClass(dClass dClass);

    /**
     * 删除班级信息
     *
     * @param id 班级信息主键
     * @return 结果
     */
    public int deletedClassById(String id);

    /**
     * 批量删除班级信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletedClassByIds(String[] ids);
}
