package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Drepair;
import com.ruoyi.system.mapper.DrepairMapper;
import com.ruoyi.system.service.IDrepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 维修信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-25
 */
@Service
public class DrepairServiceImpl implements IDrepairService {
    @Autowired
    private DrepairMapper drepairMapper;

    /**
     * 查询维修信息
     *
     * @param id 维修信息主键
     * @return 维修信息
     */
    @Override
    public Drepair selectDrepairById(String id) {
        return drepairMapper.selectDrepairById(id);
    }

    /**
     * 查询维修信息列表
     *
     * @param drepair 维修信息
     * @return 维修信息
     */
    @Override
    public List<Drepair> selectDrepairList(Drepair drepair) {
        return drepairMapper.selectDrepairList(drepair);
    }

    /**
     * 新增维修信息
     *
     * @param drepair 维修信息
     * @return 结果
     */
    @Override
    public int insertDrepair(Drepair drepair) {
        drepair.setId(UUID.randomUUID().toString());
        drepair.setCreateTime(DateUtils.getNowDate());
        return drepairMapper.insertDrepair(drepair);
    }

    /**
     * 修改维修信息
     *
     * @param drepair 维修信息
     * @return 结果
     */
    @Override
    public int updateDrepair(Drepair drepair) {
        drepair.setUpdateTime(DateUtils.getNowDate());
        return drepairMapper.updateDrepair(drepair);
    }

    /**
     * 批量删除维修信息
     *
     * @param ids 需要删除的维修信息主键
     * @return 结果
     */
    @Override
    public int deleteDrepairByIds(String ids) {
        return drepairMapper.deleteDrepairByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除维修信息信息
     *
     * @param id 维修信息主键
     * @return 结果
     */
    @Override
    public int deleteDrepairById(String id) {
        return drepairMapper.deleteDrepairById(id);
    }
}
