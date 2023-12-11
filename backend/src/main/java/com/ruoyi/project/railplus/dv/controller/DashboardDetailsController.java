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
import com.ruoyi.project.railplus.dv.domain.DashboardDetails;
import com.ruoyi.project.railplus.dv.service.IDashboardDetailsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * DashboardDetailsController
 * 
 * @author ruoyi
 * @date 2023-12-12
 */
@RestController
@RequestMapping("/dv/dashboardDetails")
public class DashboardDetailsController extends BaseController
{
    @Autowired
    private IDashboardDetailsService dashboardDetailsService;

    /**
     * 查询DashboardDetails列表
     */
    @PreAuthorize("@ss.hasPermi('dv:dashboardDetails:list')")
    @GetMapping("/list")
    public TableDataInfo list(DashboardDetails dashboardDetails)
    {
        startPage();
        List<DashboardDetails> list = dashboardDetailsService.selectDashboardDetailsList(dashboardDetails);
        return getDataTable(list);
    }

    /**
     * 导出DashboardDetails列表
     */
    @PreAuthorize("@ss.hasPermi('dv:dashboardDetails:export')")
    @Log(title = "DashboardDetails", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DashboardDetails dashboardDetails)
    {
        List<DashboardDetails> list = dashboardDetailsService.selectDashboardDetailsList(dashboardDetails);
        ExcelUtil<DashboardDetails> util = new ExcelUtil<DashboardDetails>(DashboardDetails.class);
        util.exportExcel(response, list, "DashboardDetails数据");
    }

    /**
     * 获取DashboardDetails详细信息
     */
    @PreAuthorize("@ss.hasPermi('dv:dashboardDetails:query')")
    @GetMapping(value = "/{dashboardId}")
    public AjaxResult getInfo(@PathVariable("dashboardId") String dashboardId)
    {
        return success(dashboardDetailsService.selectDashboardDetailsByDashboardId(dashboardId));
    }

    /**
     * 新增DashboardDetails
     */
    @PreAuthorize("@ss.hasPermi('dv:dashboardDetails:add')")
    @Log(title = "DashboardDetails", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DashboardDetails dashboardDetails)
    {
        return toAjax(dashboardDetailsService.insertDashboardDetails(dashboardDetails));
    }

    /**
     * 修改DashboardDetails
     */
    @PreAuthorize("@ss.hasPermi('dv:dashboardDetails:edit')")
    @Log(title = "DashboardDetails", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DashboardDetails dashboardDetails)
    {
        return toAjax(dashboardDetailsService.updateDashboardDetails(dashboardDetails));
    }

    /**
     * 删除DashboardDetails
     */
    @PreAuthorize("@ss.hasPermi('dv:dashboardDetails:remove')")
    @Log(title = "DashboardDetails", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dashboardIds}")
    public AjaxResult remove(@PathVariable String[] dashboardIds)
    {
        return toAjax(dashboardDetailsService.deleteDashboardDetailsByDashboardIds(dashboardIds));
    }
}
