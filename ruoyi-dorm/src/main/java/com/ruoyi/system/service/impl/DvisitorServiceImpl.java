package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Dvisitor;
import com.ruoyi.system.mapper.DvisitorMapper;
import com.ruoyi.system.service.IDvisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 访客信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-25
 */
@Service
public class DvisitorServiceImpl implements IDvisitorService {
    @Autowired
    private DvisitorMapper dvisitorMapper;

    /**
     * 查询访客信息
     *
     * @param id 访客信息主键
     * @return 访客信息
     */
    @Override
    public Dvisitor selectDvisitorById(String id) {
        return dvisitorMapper.selectDvisitorById(id);
    }

    /**
     * 查询访客信息列表
     *
     * @param dvisitor 访客信息
     * @return 访客信息
     */
    @Override
    public List<Dvisitor> selectDvisitorList(Dvisitor dvisitor) {
        return dvisitorMapper.selectDvisitorList(dvisitor);
    }

    /**
     * 新增访客信息
     *
     * @param dvisitor 访客信息
     * @return 结果
     */
    @Override
    public int insertDvisitor(Dvisitor dvisitor) {
        dvisitor.setId(UUID.randomUUID().toString());
        dvisitor.setCreateTime(DateUtils.getNowDate());
        return dvisitorMapper.insertDvisitor(dvisitor);
    }

    /**
     * 修改访客信息
     *
     * @param dvisitor 访客信息
     * @return 结果
     */
    @Override
    public int updateDvisitor(Dvisitor dvisitor) {
        dvisitor.setUpdateTime(DateUtils.getNowDate());
        return dvisitorMapper.updateDvisitor(dvisitor);
    }

    /**
     * 批量删除访客信息
     *
     * @param ids 需要删除的访客信息主键
     * @return 结果
     */
    @Override
    public int deleteDvisitorByIds(String ids) {
        return dvisitorMapper.deleteDvisitorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除访客信息信息
     *
     * @param id 访客信息主键
     * @return 结果
     */
    @Override
    public int deleteDvisitorById(String id) {
        return dvisitorMapper.deleteDvisitorById(id);
    }
}
