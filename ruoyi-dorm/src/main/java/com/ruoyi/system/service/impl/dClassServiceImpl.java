package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.dClass;
import com.ruoyi.system.mapper.DstudentMapper;
import com.ruoyi.system.mapper.dClassMapper;
import com.ruoyi.system.service.IdClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 班级信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-25
 */
@Service
public class dClassServiceImpl implements IdClassService {
    @Autowired
    private dClassMapper dClassMapper;
    @Autowired
    DstudentMapper dstudentMapper;

    /**
     * 查询班级信息
     *
     * @param id 班级信息主键
     * @return 班级信息
     */
    @Override
    public dClass selectdClassById(String id) {
        return dClassMapper.selectdClassById(id);
    }

    /**
     * 查询班级信息列表
     *
     * @param dClass 班级信息
     * @return 班级信息
     */
    @Override
    public List<dClass> selectdClassList(dClass dClass) {
        return dClassMapper.selectdClassList(dClass);
    }

    /**
     * 新增班级信息
     *
     * @param dClass 班级信息
     * @return 结果
     */
    @Override
    public int insertdClass(dClass dClass) {
        dClass.setId(UUID.randomUUID().toString());
        dClass.setCreateTime(DateUtils.getNowDate());
        return dClassMapper.insertdClass(dClass);
    }

    /**
     * 修改班级信息
     *
     * @param dClass 班级信息
     * @return 结果
     */
    @Override
    public int updatedClass(dClass dClass) {
        dClass.setUpdateTime(DateUtils.getNowDate());
        return dClassMapper.updatedClass(dClass);
    }

    /**
     * 批量删除班级信息
     *
     * @param ids 需要删除的班级信息主键
     * @return 结果
     */
    @Override
    public int deletedClassByIds(String ids) {
        List<String> stringList = Arrays.asList(ids.split(","));
        for (String id : stringList) {
            if (dstudentMapper.selectStudentByClassId(id).size()>0){
                return 0;
            }
        }
        return dClassMapper.deletedClassByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除班级信息信息
     *
     * @param id 班级信息主键
     * @return 结果
     */
    @Override
    public int deletedClassById(String id) {
        return dClassMapper.deletedClassById(id);
    }
}
