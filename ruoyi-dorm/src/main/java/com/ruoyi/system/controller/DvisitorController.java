package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Dvisitor;
import com.ruoyi.system.service.IDvisitorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 访客信息Controller
 *
 * @author ruoyi
 * @date 2023-04-25
 */
@Controller
@RequestMapping("/system/dvisitor")
public class DvisitorController extends BaseController {
    private String prefix = "system/dvisitor";

    @Autowired
    private IDvisitorService dvisitorService;

    @RequiresPermissions("system:dvisitor:view")
    @GetMapping()
    public String dvisitor() {
        return prefix + "/dvisitor";
    }

    /**
     * 查询访客信息列表
     */
    @RequiresPermissions("system:dvisitor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Dvisitor dvisitor) {
        startPage();
        List<Dvisitor> list = dvisitorService.selectDvisitorList(dvisitor);
        return getDataTable(list);
    }

    /**
     * 导出访客信息列表
     */
    @RequiresPermissions("system:dvisitor:export")
    @Log(title = "访客信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Dvisitor dvisitor) {
        List<Dvisitor> list = dvisitorService.selectDvisitorList(dvisitor);
        ExcelUtil<Dvisitor> util = new ExcelUtil<Dvisitor>(Dvisitor.class);
        return util.exportExcel(list, "访客信息数据");
    }

    /**
     * 新增访客信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存访客信息
     */
    @RequiresPermissions("system:dvisitor:add")
    @Log(title = "访客信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Dvisitor dvisitor) {
        return toAjax(dvisitorService.insertDvisitor(dvisitor));
    }

    /**
     * 修改访客信息
     */
    @RequiresPermissions("system:dvisitor:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        Dvisitor dvisitor = dvisitorService.selectDvisitorById(id);
        mmap.put("dvisitor", dvisitor);
        return prefix + "/edit";
    }

    /**
     * 修改保存访客信息
     */
    @RequiresPermissions("system:dvisitor:edit")
    @Log(title = "访客信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Dvisitor dvisitor) {
        return toAjax(dvisitorService.updateDvisitor(dvisitor));
    }

    /**
     * 删除访客信息
     */
    @RequiresPermissions("system:dvisitor:remove")
    @Log(title = "访客信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(dvisitorService.deleteDvisitorByIds(ids));
    }
}
