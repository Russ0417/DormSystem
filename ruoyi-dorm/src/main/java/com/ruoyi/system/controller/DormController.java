package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Dorm;
import com.ruoyi.system.service.IDormService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 宿舍信息Controller
 *
 * @author ruoyi
 * @date 2023-04-25
 */
@Controller
@RequestMapping("/system/dorm")
public class DormController extends BaseController {
    private String prefix = "system/dorm";

    @Autowired
    private IDormService dormService;

    @RequiresPermissions("system:dorm:view")
    @GetMapping()
    public String dorm() {
        return prefix + "/dorm";
    }

    /**
     * 查询宿舍信息列表
     */
    @RequiresPermissions("system:dorm:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Dorm dorm) {
        startPage();
        List<Dorm> list = dormService.selectDormList(dorm);
        return getDataTable(list);
    }

    /**
     * 导出宿舍信息列表
     */
    @RequiresPermissions("system:dorm:export")
    @Log(title = "宿舍信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Dorm dorm) {
        List<Dorm> list = dormService.selectDormList(dorm);
        ExcelUtil<Dorm> util = new ExcelUtil<Dorm>(Dorm.class);
        return util.exportExcel(list, "宿舍信息数据");
    }

    /**
     * 新增宿舍信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存宿舍信息
     */
    @RequiresPermissions("system:dorm:add")
    @Log(title = "宿舍信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Dorm dorm) {
        return toAjax(dormService.insertDorm(dorm));
    }

    /**
     * 修改宿舍信息
     */
    @RequiresPermissions("system:dorm:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        Dorm dorm = dormService.selectDormById(id);
        mmap.put("dorm", dorm);
        return prefix + "/edit";
    }

    /**
     * 修改保存宿舍信息
     */
    @RequiresPermissions("system:dorm:edit")
    @Log(title = "宿舍信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Dorm dorm) {
        return toAjax(dormService.updateDorm(dorm));
    }

    /**
     * 删除宿舍信息
     */
    @RequiresPermissions("system:dorm:remove")
    @Log(title = "宿舍信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(dormService.deleteDormByIds(ids));
    }
}
