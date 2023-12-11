package com.ruoyi.project.railplus.dv.mapper;

import java.util.List;
import com.ruoyi.project.railplus.dv.domain.Dashboard;

/**
 * DashboardMapper接口
 * 
 * @author ruoyi
 * @date 2023-12-11
 */
public interface DashboardMapper 
{
    /**
     * 查询Dashboard
     * 
     * @param dashboardId Dashboard主键
     * @return Dashboard
     */
    public Dashboard selectDashboardByDashboardId(String dashboardId);

    /**
     * 查询Dashboard列表
     * 
     * @param dashboard Dashboard
     * @return Dashboard集合
     */
    public List<Dashboard> selectDashboardList(Dashboard dashboard);

    /**
     * 新增Dashboard
     * 
     * @param dashboard Dashboard
     * @return 结果
     */
    public int insertDashboard(Dashboard dashboard);

    /**
     * 修改Dashboard
     * 
     * @param dashboard Dashboard
     * @return 结果
     */
    public int updateDashboard(Dashboard dashboard);

    /**
     * 删除Dashboard
     * 
     * @param dashboardId Dashboard主键
     * @return 结果
     */
    public int deleteDashboardByDashboardId(String dashboardId);

    /**
     * 批量删除Dashboard
     * 
     * @param dashboardIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDashboardByDashboardIds(String[] dashboardIds);
}
