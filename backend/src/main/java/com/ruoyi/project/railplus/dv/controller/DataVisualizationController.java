package com.ruoyi.project.railplus.dv.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.railplus.dv.service.IDataVisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dv/common")
public class DataVisualizationController extends BaseController {

    @Autowired
    private IDataVisualizationService dataVisualizationService;

    @GetMapping("/c")
    public AjaxResult getInfo(@RequestParam("chartName") String chartName)
    {
        return success(dataVisualizationService.selectChartByChartName(chartName));
    }

    @GetMapping("/dp")
    public AjaxResult getDashboardPreview(@RequestParam("dashboardId") String dashboardId)
    {
        return success(dataVisualizationService.selectDashboardPreview(dashboardId));
    }
}
