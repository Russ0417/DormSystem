package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Dormgrade;
import com.ruoyi.system.service.IDormgradeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍卫生Controller
 * 
 * @author ruoyi
 * @date 2023-04-26
 */
@Controller
@RequestMapping("/system/dormgrade")
public class DormgradeController extends BaseController
{
    private String prefix = "system/dormgrade";

    @Autowired
    private IDormgradeService dormgradeService;

    @RequiresPermissions("system:dormgrade:view")
    @GetMapping()
    public String dormgrade()
    {
        return prefix + "/dormgrade";
    }

    /**
     * 查询宿舍卫生列表
     */
    @RequiresPermissions("system:dormgrade:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Dormgrade dormgrade)
    {
        startPage();
        List<Dormgrade> list = dormgradeService.selectDormgradeList(dormgrade);
        return getDataTable(list);
    }

    /**
     * 导出宿舍卫生列表
     */
    @RequiresPermissions("system:dormgrade:export")
    @Log(title = "宿舍卫生", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Dormgrade dormgrade)
    {
        List<Dormgrade> list = dormgradeService.selectDormgradeList(dormgrade);
        ExcelUtil<Dormgrade> util = new ExcelUtil<Dormgrade>(Dormgrade.class);
        return util.exportExcel(list, "宿舍卫生数据");
    }

    /**
     * 新增宿舍卫生
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存宿舍卫生
     */
    @RequiresPermissions("system:dormgrade:add")
    @Log(title = "宿舍卫生", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Dormgrade dormgrade)
    {
        return toAjax(dormgradeService.insertDormgrade(dormgrade));
    }

    /**
     * 修改宿舍卫生
     */
    @RequiresPermissions("system:dormgrade:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        Dormgrade dormgrade = dormgradeService.selectDormgradeById(id);
        mmap.put("dormgrade", dormgrade);
        return prefix + "/edit";
    }

    /**
     * 修改保存宿舍卫生
     */
    @RequiresPermissions("system:dormgrade:edit")
    @Log(title = "宿舍卫生", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Dormgrade dormgrade)
    {
        return toAjax(dormgradeService.updateDormgrade(dormgrade));
    }

    /**
     * 删除宿舍卫生
     */
    @RequiresPermissions("system:dormgrade:remove")
    @Log(title = "宿舍卫生", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dormgradeService.deleteDormgradeByIds(ids));
    }
}
