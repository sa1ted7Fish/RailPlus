package com.ruoyi.project.railplus.dv.service;

import java.util.List;
import com.ruoyi.project.railplus.dv.domain.Chart;

/**
 * ChartService接口
 * 
 * @author ruoyi
 * @date 2023-12-11
 */
public interface IChartService 
{
    /**
     * 查询Chart
     * 
     * @param chartId Chart主键
     * @return Chart
     */
    public Chart selectChartByChartId(String chartId);

    /**
     * 查询Chart列表
     * 
     * @param chart Chart
     * @return Chart集合
     */
    public List<Chart> selectChartList(Chart chart);

    /**
     * 新增Chart
     * 
     * @param chart Chart
     * @return 结果
     */
    public int insertChart(Chart chart);

    /**
     * 修改Chart
     * 
     * @param chart Chart
     * @return 结果
     */
    public int updateChart(Chart chart);

    /**
     * 批量删除Chart
     * 
     * @param chartIds 需要删除的Chart主键集合
     * @return 结果
     */
    public int deleteChartByChartIds(String[] chartIds);

    /**
     * 删除Chart信息
     * 
     * @param chartId Chart主键
     * @return 结果
     */
    public int deleteChartByChartId(String chartId);
}
