package com.ruoyi.project.railplus.dv.service;

import java.util.List;
import com.ruoyi.project.railplus.dv.domain.DashboardDetails;

/**
 * DashboardDetailsService接口
 * 
 * @author ruoyi
 * @date 2023-12-12
 */
public interface IDashboardDetailsService 
{
    /**
     * 查询DashboardDetails
     * 
     * @param dashboardId DashboardDetails主键
     * @return DashboardDetails
     */
    public DashboardDetails selectDashboardDetailsByDashboardId(String dashboardId);

    /**
     * 查询DashboardDetails列表
     * 
     * @param dashboardDetails DashboardDetails
     * @return DashboardDetails集合
     */
    public List<DashboardDetails> selectDashboardDetailsList(DashboardDetails dashboardDetails);

    /**
     * 新增DashboardDetails
     * 
     * @param dashboardDetails DashboardDetails
     * @return 结果
     */
    public int insertDashboardDetails(DashboardDetails dashboardDetails);

    /**
     * 修改DashboardDetails
     * 
     * @param dashboardDetails DashboardDetails
     * @return 结果
     */
    public int updateDashboardDetails(DashboardDetails dashboardDetails);

    /**
     * 批量删除DashboardDetails
     * 
     * @param dashboardIds 需要删除的DashboardDetails主键集合
     * @return 结果
     */
    public int deleteDashboardDetailsByDashboardIds(String[] dashboardIds);

    /**
     * 删除DashboardDetails信息
     * 
     * @param dashboardId DashboardDetails主键
     * @return 结果
     */
    public int deleteDashboardDetailsByDashboardId(String dashboardId);
}
