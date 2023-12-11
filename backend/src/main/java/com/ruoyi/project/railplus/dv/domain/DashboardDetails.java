package com.ruoyi.project.railplus.dv.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * DashboardDetails对象 rp_dashboard_details
 * 
 * @author ruoyi
 * @date 2023-12-12
 */
public class DashboardDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dashboardId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chartId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long x;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long y;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long w;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long h;

    public void setDashboardId(String dashboardId) 
    {
        this.dashboardId = dashboardId;
    }

    public String getDashboardId() 
    {
        return dashboardId;
    }
    public void setChartId(String chartId) 
    {
        this.chartId = chartId;
    }

    public String getChartId() 
    {
        return chartId;
    }
    public void setX(Long x) 
    {
        this.x = x;
    }

    public Long getX() 
    {
        return x;
    }
    public void setY(Long y) 
    {
        this.y = y;
    }

    public Long getY() 
    {
        return y;
    }
    public void setW(Long w) 
    {
        this.w = w;
    }

    public Long getW() 
    {
        return w;
    }
    public void setH(Long h) 
    {
        this.h = h;
    }

    public Long getH() 
    {
        return h;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dashboardId", getDashboardId())
            .append("chartId", getChartId())
            .append("x", getX())
            .append("y", getY())
            .append("w", getW())
            .append("h", getH())
            .toString();
    }
}
