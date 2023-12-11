package com.ruoyi.project.railplus.dv.service.impl;

import java.util.List;

import com.ruoyi.common.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.railplus.dv.mapper.DashboardMapper;
import com.ruoyi.project.railplus.dv.domain.Dashboard;
import com.ruoyi.project.railplus.dv.service.IDashboardService;

/**
 * DashboardService业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-11
 */
@Service
public class DashboardServiceImpl implements IDashboardService 
{
    @Autowired
    private DashboardMapper dashboardMapper;

    /**
     * 查询Dashboard
     * 
     * @param dashboardId Dashboard主键
     * @return Dashboard
     */
    @Override
    public Dashboard selectDashboardByDashboardId(String dashboardId)
    {
        return dashboardMapper.selectDashboardByDashboardId(dashboardId);
    }

    /**
     * 查询Dashboard列表
     * 
     * @param dashboard Dashboard
     * @return Dashboard
     */
    @Override
    public List<Dashboard> selectDashboardList(Dashboard dashboard)
    {
        return dashboardMapper.selectDashboardList(dashboard);
    }

    /**
     * 新增Dashboard
     * 
     * @param dashboard Dashboard
     * @return 结果
     */
    @Override
    public int insertDashboard(Dashboard dashboard)
    {
        String dashboardId = UUID.fastUUID().toString();
        dashboard.setDashboardId(dashboardId);
        return dashboardMapper.insertDashboard(dashboard);
    }

    /**
     * 修改Dashboard
     * 
     * @param dashboard Dashboard
     * @return 结果
     */
    @Override
    public int updateDashboard(Dashboard dashboard)
    {
        return dashboardMapper.updateDashboard(dashboard);
    }

    /**
     * 批量删除Dashboard
     * 
     * @param dashboardIds 需要删除的Dashboard主键
     * @return 结果
     */
    @Override
    public int deleteDashboardByDashboardIds(String[] dashboardIds)
    {
        return dashboardMapper.deleteDashboardByDashboardIds(dashboardIds);
    }

    /**
     * 删除Dashboard信息
     * 
     * @param dashboardId Dashboard主键
     * @return 结果
     */
    @Override
    public int deleteDashboardByDashboardId(String dashboardId)
    {
        return dashboardMapper.deleteDashboardByDashboardId(dashboardId);
    }
}
