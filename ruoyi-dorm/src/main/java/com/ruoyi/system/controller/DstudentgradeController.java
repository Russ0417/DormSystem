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
import com.ruoyi.system.domain.Dstudentgrade;
import com.ruoyi.system.service.IDstudentgradeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生卫生Controller
 * 
 * @author ruoyi
 * @date 2023-04-26
 */
@Controller
@RequestMapping("/system/dstudentgrade")
public class DstudentgradeController extends BaseController
{
    private String prefix = "system/dstudentgrade";

    @Autowired
    private IDstudentgradeService dstudentgradeService;

    @RequiresPermissions("system:dstudentgrade:view")
    @GetMapping()
    public String dstudentgrade()
    {
        return prefix + "/dstudentgrade";
    }

    /**
     * 查询学生卫生列表
     */
    @RequiresPermissions("system:dstudentgrade:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Dstudentgrade dstudentgrade)
    {
        startPage();
        List<Dstudentgrade> list = dstudentgradeService.selectDstudentgradeList(dstudentgrade);
        return getDataTable(list);
    }

    /**
     * 导出学生卫生列表
     */
    @RequiresPermissions("system:dstudentgrade:export")
    @Log(title = "学生卫生", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Dstudentgrade dstudentgrade)
    {
        List<Dstudentgrade> list = dstudentgradeService.selectDstudentgradeList(dstudentgrade);
        ExcelUtil<Dstudentgrade> util = new ExcelUtil<Dstudentgrade>(Dstudentgrade.class);
        return util.exportExcel(list, "学生卫生数据");
    }

    /**
     * 新增学生卫生
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生卫生
     */
    @RequiresPermissions("system:dstudentgrade:add")
    @Log(title = "学生卫生", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Dstudentgrade dstudentgrade)
    {
        return toAjax(dstudentgradeService.insertDstudentgrade(dstudentgrade));
    }

    /**
     * 修改学生卫生
     */
    @RequiresPermissions("system:dstudentgrade:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        Dstudentgrade dstudentgrade = dstudentgradeService.selectDstudentgradeById(id);
        mmap.put("dstudentgrade", dstudentgrade);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生卫生
     */
    @RequiresPermissions("system:dstudentgrade:edit")
    @Log(title = "学生卫生", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Dstudentgrade dstudentgrade)
    {
        return toAjax(dstudentgradeService.updateDstudentgrade(dstudentgrade));
    }

    /**
     * 删除学生卫生
     */
    @RequiresPermissions("system:dstudentgrade:remove")
    @Log(title = "学生卫生", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dstudentgradeService.deleteDstudentgradeByIds(ids));
    }
}
