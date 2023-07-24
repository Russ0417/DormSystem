package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Dorm;
import com.ruoyi.system.mapper.DormMapper;
import com.ruoyi.system.service.IDormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 宿舍信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-25
 */
@Service
public class DormServiceImpl implements IDormService {
    @Autowired
    private DormMapper dormMapper;

    /**
     * 查询宿舍信息
     *
     * @param id 宿舍信息主键
     * @return 宿舍信息
     */
    @Override
    public Dorm selectDormById(String id) {
        return dormMapper.selectDormById(id);
    }

    /**
     * 查询宿舍信息列表
     *
     * @param dorm 宿舍信息
     * @return 宿舍信息
     */
    @Override
    public List<Dorm> selectDormList(Dorm dorm) {
        return dormMapper.selectDormList(dorm);
    }

    /**
     * 新增宿舍信息
     *
     * @param dorm 宿舍信息
     * @return 结果
     */
    @Override
    public int insertDorm(Dorm dorm) {
        dorm.setId(UUID.randomUUID().toString());
        dorm.setCreateTime(DateUtils.getNowDate());
        return dormMapper.insertDorm(dorm);
    }

    /**
     * 修改宿舍信息
     *
     * @param dorm 宿舍信息
     * @return 结果
     */
    @Override
    public int updateDorm(Dorm dorm) {
        dorm.setUpdateTime(DateUtils.getNowDate());
        return dormMapper.updateDorm(dorm);
    }

    /**
     * 批量删除宿舍信息
     *
     * @param ids 需要删除的宿舍信息主键
     * @return 结果
     */
    @Override
    public int deleteDormByIds(String ids) {
        return dormMapper.deleteDormByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除宿舍信息信息
     *
     * @param id 宿舍信息主键
     * @return 结果
     */
    @Override
    public int deleteDormById(String id) {
        return dormMapper.deleteDormById(id);
    }
}
