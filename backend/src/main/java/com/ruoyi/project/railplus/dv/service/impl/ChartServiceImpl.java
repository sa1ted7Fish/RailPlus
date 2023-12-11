package com.ruoyi.project.railplus.dv.service.impl;

import java.util.List;

import com.ruoyi.common.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.railplus.dv.mapper.ChartMapper;
import com.ruoyi.project.railplus.dv.domain.Chart;
import com.ruoyi.project.railplus.dv.service.IChartService;

/**
 * ChartService业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-11
 */
@Service
public class ChartServiceImpl implements IChartService 
{
    @Autowired
    private ChartMapper chartMapper;

    /**
     * 查询Chart
     * 
     * @param chartId Chart主键
     * @return Chart
     */
    @Override
    public Chart selectChartByChartId(String chartId)
    {
        return chartMapper.selectChartByChartId(chartId);
    }

    /**
     * 查询Chart列表
     * 
     * @param chart Chart
     * @return Chart
     */
    @Override
    public List<Chart> selectChartList(Chart chart)
    {
        return chartMapper.selectChartList(chart);
    }

    /**
     * 新增Chart
     * 
     * @param chart Chart
     * @return 结果
     */
    @Override
    public int insertChart(Chart chart)
    {
        String chartId = UUID.fastUUID().toString();
        chart.setChartId(chartId);
        return chartMapper.insertChart(chart);
    }

    /**
     * 修改Chart
     * 
     * @param chart Chart
     * @return 结果
     */
    @Override
    public int updateChart(Chart chart)
    {
        return chartMapper.updateChart(chart);
    }

    /**
     * 批量删除Chart
     * 
     * @param chartIds 需要删除的Chart主键
     * @return 结果
     */
    @Override
    public int deleteChartByChartIds(String[] chartIds)
    {
        return chartMapper.deleteChartByChartIds(chartIds);
    }

    /**
     * 删除Chart信息
     * 
     * @param chartId Chart主键
     * @return 结果
     */
    @Override
    public int deleteChartByChartId(String chartId)
    {
        return chartMapper.deleteChartByChartId(chartId);
    }
}
