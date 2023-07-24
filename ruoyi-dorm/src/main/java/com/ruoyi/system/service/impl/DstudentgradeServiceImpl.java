package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Dstudentgrade;
import com.ruoyi.system.mapper.DstudentgradeMapper;
import com.ruoyi.system.service.IDstudentgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 学生卫生Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-26
 */
@Service
public class DstudentgradeServiceImpl implements IDstudentgradeService {
    @Autowired
    private DstudentgradeMapper dstudentgradeMapper;

    /**
     * 查询学生卫生
     *
     * @param id 学生卫生主键
     * @return 学生卫生
     */
    @Override
    public Dstudentgrade selectDstudentgradeById(String id) {
        return dstudentgradeMapper.selectDstudentgradeById(id);
    }

    /**
     * 查询学生卫生列表
     *
     * @param dstudentgrade 学生卫生
     * @return 学生卫生
     */
    @Override
    public List<Dstudentgrade> selectDstudentgradeList(Dstudentgrade dstudentgrade) {
        return dstudentgradeMapper.selectDstudentgradeList(dstudentgrade);
    }

    /**
     * 新增学生卫生
     *
     * @param dstudentgrade 学生卫生
     * @return 结果
     */
    @Override
    public int insertDstudentgrade(Dstudentgrade dstudentgrade) {
        dstudentgrade.setId(UUID.randomUUID().toString());
        dstudentgrade.setCreateTime(DateUtils.getNowDate());
        return dstudentgradeMapper.insertDstudentgrade(dstudentgrade);
    }

    /**
     * 修改学生卫生
     *
     * @param dstudentgrade 学生卫生
     * @return 结果
     */
    @Override
    public int updateDstudentgrade(Dstudentgrade dstudentgrade) {
        dstudentgrade.setUpdateTime(DateUtils.getNowDate());
        return dstudentgradeMapper.updateDstudentgrade(dstudentgrade);
    }

    /**
     * 批量删除学生卫生
     *
     * @param ids 需要删除的学生卫生主键
     * @return 结果
     */
    @Override
    public int deleteDstudentgradeByIds(String ids) {
        return dstudentgradeMapper.deleteDstudentgradeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生卫生信息
     *
     * @param id 学生卫生主键
     * @return 结果
     */
    @Override
    public int deleteDstudentgradeById(String id) {
        return dstudentgradeMapper.deleteDstudentgradeById(id);
    }
}
