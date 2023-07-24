package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Dormgrade;
import com.ruoyi.system.mapper.DormgradeMapper;
import com.ruoyi.system.service.IDormgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 宿舍卫生Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-26
 */
@Service
public class DormgradeServiceImpl implements IDormgradeService {
    @Autowired
    private DormgradeMapper dormgradeMapper;

    /**
     * 查询宿舍卫生
     *
     * @param id 宿舍卫生主键
     * @return 宿舍卫生
     */
    @Override
    public Dormgrade selectDormgradeById(String id) {
        return dormgradeMapper.selectDormgradeById(id);
    }

    /**
     * 查询宿舍卫生列表
     *
     * @param dormgrade 宿舍卫生
     * @return 宿舍卫生
     */
    @Override
    public List<Dormgrade> selectDormgradeList(Dormgrade dormgrade) {
        return dormgradeMapper.selectDormgradeList(dormgrade);
    }

    /**
     * 新增宿舍卫生
     *
     * @param dormgrade 宿舍卫生
     * @return 结果
     */
    @Override
    public int insertDormgrade(Dormgrade dormgrade) {
        dormgrade.setId(UUID.randomUUID().toString());
        dormgrade.setCreateTime(DateUtils.getNowDate());
        return dormgradeMapper.insertDormgrade(dormgrade);
    }

    /**
     * 修改宿舍卫生
     *
     * @param dormgrade 宿舍卫生
     * @return 结果
     */
    @Override
    public int updateDormgrade(Dormgrade dormgrade) {
        dormgrade.setUpdateTime(DateUtils.getNowDate());
        return dormgradeMapper.updateDormgrade(dormgrade);
    }

    /**
     * 批量删除宿舍卫生
     *
     * @param ids 需要删除的宿舍卫生主键
     * @return 结果
     */
    @Override
    public int deleteDormgradeByIds(String ids) {
        return dormgradeMapper.deleteDormgradeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除宿舍卫生信息
     *
     * @param id 宿舍卫生主键
     * @return 结果
     */
    @Override
    public int deleteDormgradeById(String id) {
        return dormgradeMapper.deleteDormgradeById(id);
    }
}
