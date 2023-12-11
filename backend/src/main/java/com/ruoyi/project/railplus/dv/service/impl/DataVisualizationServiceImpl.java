package com.ruoyi.project.railplus.dv.service.impl;

import com.ruoyi.project.railplus.dv.domain.Chart;
import com.ruoyi.project.railplus.dv.mapper.DataVisualizationMapper;
import com.ruoyi.project.railplus.dv.service.IDataVisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataVisualizationServiceImpl implements IDataVisualizationService {

    @Autowired
    private DataVisualizationMapper dataVisualizationMapper;

    @Override
    public Map<String, Object> selectChartByChartName(String chartName) {
        return dataVisualizationMapper.selectChartByChartName(chartName);
    }

    @Override
    public List<Map<String, Object>> selectDashboardPreview(String dashboardId) {
        return dataVisualizationMapper.selectDashboardPreview(dashboardId);
    }
}
