package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Dstudent;
import com.ruoyi.system.service.IDstudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生信息Controller
 *
 * @author ruoyi
 * @date 2023-04-25
 */
@Controller
@RequestMapping("/system/dstudent")
public class DstudentController extends BaseController {
    private String prefix = "system/dstudent";

    @Autowired
    private IDstudentService dstudentService;

    @RequiresPermissions("system:dstudent:view")
    @GetMapping()
    public String dstudent() {
        return prefix + "/dstudent";
    }

    /**
     * 查询学生信息列表
     */
    @RequiresPermissions("system:dstudent:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Dstudent dstudent) {
        startPage();
        List<Dstudent> list = dstudentService.selectDstudentList(dstudent);
        return getDataTable(list);
    }

    /**
     * 导出学生信息列表
     */
    @RequiresPermissions("system:dstudent:export")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Dstudent dstudent) {
        List<Dstudent> list = dstudentService.selectDstudentList(dstudent);
        ExcelUtil<Dstudent> util = new ExcelUtil<Dstudent>(Dstudent.class);
        return util.exportExcel(list, "学生信息数据");
    }

    /**
     * 新增学生信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存学生信息
     */
    @RequiresPermissions("system:dstudent:add")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Dstudent dstudent) {
        return toAjax(dstudentService.insertDstudent(dstudent));
    }

    /**
     * 修改学生信息
     */
    @RequiresPermissions("system:dstudent:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        Dstudent dstudent = dstudentService.selectDstudentById(id);
        mmap.put("dstudent", dstudent);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生信息
     */
    @RequiresPermissions("system:dstudent:edit")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Dstudent dstudent) {
        return toAjax(dstudentService.updateDstudent(dstudent));
    }

    /**
     * 删除学生信息
     */
    @RequiresPermissions("system:dstudent:remove")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(dstudentService.deleteDstudentByIds(ids));
    }
}
