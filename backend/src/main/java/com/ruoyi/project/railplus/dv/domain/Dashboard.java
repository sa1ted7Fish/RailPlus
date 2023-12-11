package com.ruoyi.project.railplus.dv.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * Dashboard对象 rp_dashboard
 * 
 * @author ruoyi
 * @date 2023-12-11
 */
public class Dashboard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String dashboardId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dashboardName;

    public void setDashboardId(String dashboardId) 
    {
        this.dashboardId = dashboardId;
    }

    public String getDashboardId() 
    {
        return dashboardId;
    }
    public void setDashboardName(String dashboardName) 
    {
        this.dashboardName = dashboardName;
    }

    public String getDashboardName() 
    {
        return dashboardName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dashboardId", getDashboardId())
            .append("dashboardName", getDashboardName())
            .toString();
    }
}
