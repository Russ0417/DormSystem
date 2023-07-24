package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Dstudent;
import com.ruoyi.system.mapper.DstudentMapper;
import com.ruoyi.system.service.IDstudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 学生信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-25
 */
@Service
public class DstudentServiceImpl implements IDstudentService {
    @Autowired
    private DstudentMapper dstudentMapper;

    /**
     * 查询学生信息
     *
     * @param id 学生信息主键
     * @return 学生信息
     */
    @Override
    public Dstudent selectDstudentById(String id) {
        return dstudentMapper.selectDstudentById(id);
    }

    /**
     * 查询学生信息列表
     *
     * @param dstudent 学生信息
     * @return 学生信息
     */
    @Override
    public List<Dstudent> selectDstudentList(Dstudent dstudent) {
        return dstudentMapper.selectDstudentList(dstudent);
    }

    /**
     * 新增学生信息
     *
     * @param dstudent 学生信息
     * @return 结果
     */
    @Override
    public int insertDstudent(Dstudent dstudent) {
        dstudent.setId(UUID.randomUUID().toString());
        dstudent.setCreateTime(DateUtils.getNowDate());
        return dstudentMapper.insertDstudent(dstudent);
    }

    /**
     * 修改学生信息
     *
     * @param dstudent 学生信息
     * @return 结果
     */
    @Override
    public int updateDstudent(Dstudent dstudent) {
        dstudent.setUpdateTime(DateUtils.getNowDate());
        return dstudentMapper.updateDstudent(dstudent);
    }

    /**
     * 批量删除学生信息
     *
     * @param ids 需要删除的学生信息主键
     * @return 结果
     */
    @Override
    public int deleteDstudentByIds(String ids) {
        return dstudentMapper.deleteDstudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生信息信息
     *
     * @param id 学生信息主键
     * @return 结果
     */
    @Override
    public int deleteDstudentById(String id) {
        return dstudentMapper.deleteDstudentById(id);
    }
}
