package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.dClass;
import com.ruoyi.system.service.IdClassService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级信息Controller
 *
 * @author ruoyi
 * @date 2023-04-25
 */
@Controller
@RequestMapping("/system/dclass")
public class dClassController extends BaseController {
    private String prefix = "system/dclass";

    @Autowired
    private IdClassService dClassService;

    @RequiresPermissions("system:dclass:view")
    @GetMapping()
    public String dclass() {
        return prefix + "/dclass";
    }

    /**
     * 查询班级信息列表
     */
    @RequiresPermissions("system:dclass:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(dClass dClass) {
        startPage();
        List<dClass> list = dClassService.selectdClassList(dClass);
        return getDataTable(list);
    }

    /**
     * 导出班级信息列表
     */
    @RequiresPermissions("system:dclass:export")
    @Log(title = "班级信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(dClass dClass) {
        List<dClass> list = dClassService.selectdClassList(dClass);
        ExcelUtil<dClass> util = new ExcelUtil<dClass>(dClass.class);
        return util.exportExcel(list, "班级信息数据");
    }

    /**
     * 新增班级信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存班级信息
     */
    @RequiresPermissions("system:dclass:add")
    @Log(title = "班级信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(dClass dClass) {
        return toAjax(dClassService.insertdClass(dClass));
    }

    /**
     * 修改班级信息
     */
    @RequiresPermissions("system:dclass:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map) {
        dClass dClass = dClassService.selectdClassById(id);
        map.put("dClass", dClass);
        return prefix + "/edit";
    }

    /**
     * 修改保存班级信息
     */
    @RequiresPermissions("system:dclass:edit")
    @Log(title = "班级信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(dClass dClass) {
        return toAjax(dClassService.updatedClass(dClass));
    }

    /**
     * 删除班级信息
     */
    @RequiresPermissions("system:dclass:remove")
    @Log(title = "班级信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(dClassService.deletedClassByIds(ids));
    }
}
