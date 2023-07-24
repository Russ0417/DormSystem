package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Drepair;
import com.ruoyi.system.service.IDrepairService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 维修信息Controller
 *
 * @author ruoyi
 * @date 2023-04-25
 */
@Controller
@RequestMapping("/system/drepair")
public class DrepairController extends BaseController {
    private String prefix = "system/drepair";

    @Autowired
    private IDrepairService drepairService;

    @RequiresPermissions("system:drepair:view")
    @GetMapping()
    public String drepair() {
        return prefix + "/drepair";
    }

    /**
     * 查询维修信息列表
     */
    @RequiresPermissions("system:drepair:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Drepair drepair) {
        startPage();
        List<Drepair> list = drepairService.selectDrepairList(drepair);
        return getDataTable(list);
    }

    /**
     * 导出维修信息列表
     */
    @RequiresPermissions("system:drepair:export")
    @Log(title = "维修信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Drepair drepair) {
        List<Drepair> list = drepairService.selectDrepairList(drepair);
        ExcelUtil<Drepair> util = new ExcelUtil<Drepair>(Drepair.class);
        return util.exportExcel(list, "维修信息数据");
    }

    /**
     * 新增维修信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存维修信息
     */
    @RequiresPermissions("system:drepair:add")
    @Log(title = "维修信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Drepair drepair) {
        return toAjax(drepairService.insertDrepair(drepair));
    }

    /**
     * 修改维修信息
     */
    @RequiresPermissions("system:drepair:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        Drepair drepair = drepairService.selectDrepairById(id);
        mmap.put("drepair", drepair);
        return prefix + "/edit";
    }

    /**
     * 修改保存维修信息
     */
    @RequiresPermissions("system:drepair:edit")
    @Log(title = "维修信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Drepair drepair) {
        return toAjax(drepairService.updateDrepair(drepair));
    }

    /**
     * 删除维修信息
     */
    @RequiresPermissions("system:drepair:remove")
    @Log(title = "维修信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(drepairService.deleteDrepairByIds(ids));
    }
}
