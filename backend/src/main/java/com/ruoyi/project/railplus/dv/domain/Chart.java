package com.ruoyi.project.railplus.dv.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * Chart对象 rp_chart
 * 
 * @author ruoyi
 * @date 2023-12-11
 */
public class Chart extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String chartId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chartName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String apiId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chartOption;

    public void setChartId(String chartId) 
    {
        this.chartId = chartId;
    }

    public String getChartId() 
    {
        return chartId;
    }
    public void setChartName(String chartName) 
    {
        this.chartName = chartName;
    }

    public String getChartName() 
    {
        return chartName;
    }
    public void setApiId(String apiId) 
    {
        this.apiId = apiId;
    }

    public String getApiId() 
    {
        return apiId;
    }
    public void setChartOption(String chartOption) 
    {
        this.chartOption = chartOption;
    }

    public String getChartOption() 
    {
        return chartOption;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("chartId", getChartId())
            .append("chartName", getChartName())
            .append("apiId", getApiId())
            .append("chartOption", getChartOption())
            .toString();
    }
}
