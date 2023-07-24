package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Drepair;

import java.util.List;

/**
 * 维修信息Mapper接口
 *
 * @author ruoyi
 * @date 2023-04-25
 */
public interface DrepairMapper {
    /**
     * 查询维修信息
     *
     * @param id 维修信息主键
     * @return 维修信息
     */
    public Drepair selectDrepairById(String id);

    /**
     * 查询维修信息列表
     *
     * @param drepair 维修信息
     * @return 维修信息集合
     */
    public List<Drepair> selectDrepairList(Drepair drepair);

    /**
     * 新增维修信息
     *
     * @param drepair 维修信息
     * @return 结果
     */
    public int insertDrepair(Drepair drepair);

    /**
     * 修改维修信息
     *
     * @param drepair 维修信息
     * @return 结果
     */
    public int updateDrepair(Drepair drepair);

    /**
     * 删除维修信息
     *
     * @param id 维修信息主键
     * @return 结果
     */
    public int deleteDrepairById(String id);

    /**
     * 批量删除维修信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDrepairByIds(String[] ids);
}
