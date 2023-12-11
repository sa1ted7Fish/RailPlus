package com.ruoyi.project.railplus.dv.service;

import com.ruoyi.project.railplus.dv.domain.Chart;

import java.util.List;
import java.util.Map;

public interface IDataVisualizationService {

    public Map<String, Object> selectChartByChartName(String chartName);

    public List<Map<String, Object>> selectDashboardPreview(String dashboardId);
}
