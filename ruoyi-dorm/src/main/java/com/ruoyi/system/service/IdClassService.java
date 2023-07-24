package com.ruoyi.system.service;

import com.ruoyi.system.domain.dClass;

import java.util.List;

/**
 * 班级信息Service接口
 *
 * @author ruoyi
 * @date 2023-04-25
 */
public interface IdClassService {
    /**
     * 查询班级信息
     *
     * @param id 班级信息主键
     * @return 班级信息
     */
    dClass selectdClassById(String id);

    /**
     * 查询班级信息列表
     *
     * @param dClass 班级信息
     * @return 班级信息集合
     */
    List<dClass> selectdClassList(dClass dClass);

    /**
     * 新增班级信息
     *
     * @param dClass 班级信息
     * @return 结果
     */
    int insertdClass(dClass dClass);

    /**
     * 修改班级信息
     *
     * @param dClass 班级信息
     * @return 结果
     */
    int updatedClass(dClass dClass);

    /**
     * 批量删除班级信息
     *
     * @param ids 需要删除的班级信息主键集合
     * @return 结果
     */
    int deletedClassByIds(String ids);

    /**
     * 删除班级信息信息
     *
     * @param id 班级信息主键
     * @return 结果
     */
    int deletedClassById(String id);
}
