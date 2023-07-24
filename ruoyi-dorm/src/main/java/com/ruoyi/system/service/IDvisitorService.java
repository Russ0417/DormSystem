package com.ruoyi.system.service;

import com.ruoyi.system.domain.Dvisitor;

import java.util.List;

/**
 * 访客信息Service接口
 *
 * @author ruoyi
 * @date 2023-04-25
 */
public interface IDvisitorService {
    /**
     * 查询访客信息
     *
     * @param id 访客信息主键
     * @return 访客信息
     */
    public Dvisitor selectDvisitorById(String id);

    /**
     * 查询访客信息列表
     *
     * @param dvisitor 访客信息
     * @return 访客信息集合
     */
    public List<Dvisitor> selectDvisitorList(Dvisitor dvisitor);

    /**
     * 新增访客信息
     *
     * @param dvisitor 访客信息
     * @return 结果
     */
    public int insertDvisitor(Dvisitor dvisitor);

    /**
     * 修改访客信息
     *
     * @param dvisitor 访客信息
     * @return 结果
     */
    public int updateDvisitor(Dvisitor dvisitor);

    /**
     * 批量删除访客信息
     *
     * @param ids 需要删除的访客信息主键集合
     * @return 结果
     */
    public int deleteDvisitorByIds(String ids);

    /**
     * 删除访客信息信息
     *
     * @param id 访客信息主键
     * @return 结果
     */
    public int deleteDvisitorById(String id);
}
