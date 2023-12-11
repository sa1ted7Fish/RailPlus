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
import com.ruoyi.project.railplus.dv.domain.Chart;
import com.ruoyi.project.railplus.dv.service.IChartService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * ChartController
 * 
 * @author ruoyi
 * @date 2023-12-11
 */
@RestController
@RequestMapping("/dv/chart")
public class ChartController extends BaseController
{
    @Autowired
    private IChartService chartService;

    /**
     * 查询Chart列表
     */
    @PreAuthorize("@ss.hasPermi('dv:chart:list')")
    @GetMapping("/list")
    public TableDataInfo list(Chart chart)
    {
        startPage();
        List<Chart> list = chartService.selectChartList(chart);
        return getDataTable(list);
    }

    /**
     * 导出Chart列表
     */
    @PreAuthorize("@ss.hasPermi('dv:chart:export')")
    @Log(title = "Chart", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Chart chart)
    {
        List<Chart> list = chartService.selectChartList(chart);
        ExcelUtil<Chart> util = new ExcelUtil<Chart>(Chart.class);
        util.exportExcel(response, list, "Chart数据");
    }

    /**
     * 获取Chart详细信息
     */
    @PreAuthorize("@ss.hasPermi('dv:chart:query')")
    @GetMapping(value = "/{chartId}")
    public AjaxResult getInfo(@PathVariable("chartId") String chartId)
    {
        return success(chartService.selectChartByChartId(chartId));
    }

    /**
     * 新增Chart
     */
    @PreAuthorize("@ss.hasPermi('dv:chart:add')")
    @Log(title = "Chart", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Chart chart)
    {
        return toAjax(chartService.insertChart(chart));
    }

    /**
     * 修改Chart
     */
    @PreAuthorize("@ss.hasPermi('dv:chart:edit')")
    @Log(title = "Chart", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Chart chart)
    {
        return toAjax(chartService.updateChart(chart));
    }

    /**
     * 删除Chart
     */
    @PreAuthorize("@ss.hasPermi('dv:chart:remove')")
    @Log(title = "Chart", businessType = BusinessType.DELETE)
	@DeleteMapping("/{chartIds}")
    public AjaxResult remove(@PathVariable String[] chartIds)
    {
        return toAjax(chartService.deleteChartByChartIds(chartIds));
    }
}
