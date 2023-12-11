package com.ruoyi.project.railplus.dv.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.railplus.dv.domain.Dashboard;
import com.ruoyi.project.railplus.dv.service.IDashboardService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * DashboardController
 * 
 * @author ruoyi
 * @date 2023-12-11
 */
@RestController
@RequestMapping("/dv/dashboard")
public class DashboardController extends BaseController
{
    @Autowired
    private IDashboardService dashboardService;

    /**
     * 查询Dashboard列表
     */
    @PreAuthorize("@ss.hasPermi('dv:dashboard:list')")
    @GetMapping("/list")
    public TableDataInfo list(Dashboard dashboard)
    {
        startPage();
        List<Dashboard> list = dashboardService.selectDashboardList(dashboard);
        return getDataTable(list);
    }

    /**
     * 导出Dashboard列表
     */
    @PreAuthorize("@ss.hasPermi('dv:dashboard:export')")
    @Log(title = "Dashboard", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Dashboard dashboard)
    {
        List<Dashboard> list = dashboardService.selectDashboardList(dashboard);
        ExcelUtil<Dashboard> util = new ExcelUtil<Dashboard>(Dashboard.class);
        util.exportExcel(response, list, "Dashboard数据");
    }

    /**
     * 获取Dashboard详细信息
     */
    @PreAuthorize("@ss.hasPermi('dv:dashboard:query')")
    @GetMapping(value = "/{dashboardId}")
    public AjaxResult getInfo(@PathVariable("dashboardId") String dashboardId)
    {
        return success(dashboardService.selectDashboardByDashboardId(dashboardId));
    }

    /**
     * 新增Dashboard
     */
    @PreAuthorize("@ss.hasPermi('dv:dashboard:add')")
    @Log(title = "Dashboard", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Dashboard dashboard)
    {
        return toAjax(dashboardService.insertDashboard(dashboard));
    }

    /**
     * 修改Dashboard
     */
    @PreAuthorize("@ss.hasPermi('dv:dashboard:edit')")
    @Log(title = "Dashboard", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Dashboard dashboard)
    {
        return toAjax(dashboardService.updateDashboard(dashboard));
    }

    /**
     * 删除Dashboard
     */
    @PreAuthorize("@ss.hasPermi('dv:dashboard:remove')")
    @Log(title = "Dashboard", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dashboardIds}")
    public AjaxResult remove(@PathVariable String[] dashboardIds)
    {
        return toAjax(dashboardService.deleteDashboardByDashboardIds(dashboardIds));
    }
}
