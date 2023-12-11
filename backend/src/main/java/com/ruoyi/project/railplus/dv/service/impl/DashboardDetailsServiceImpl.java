package com.ruoyi.project.railplus.dv.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.railplus.dv.mapper.DashboardDetailsMapper;
import com.ruoyi.project.railplus.dv.domain.DashboardDetails;
import com.ruoyi.project.railplus.dv.service.IDashboardDetailsService;

/**
 * DashboardDetailsService业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-12
 */
@Service
public class DashboardDetailsServiceImpl implements IDashboardDetailsService 
{
    @Autowired
    private DashboardDetailsMapper dashboardDetailsMapper;

    /**
     * 查询DashboardDetails
     * 
     * @param dashboardId DashboardDetails主键
     * @return DashboardDetails
     */
    @Override
    public DashboardDetails selectDashboardDetailsByDashboardId(String dashboardId)
    {
        return dashboardDetailsMapper.selectDashboardDetailsByDashboardId(dashboardId);
    }

    /**
     * 查询DashboardDetails列表
     * 
     * @param dashboardDetails DashboardDetails
     * @return DashboardDetails
     */
    @Override
    public List<DashboardDetails> selectDashboardDetailsList(DashboardDetails dashboardDetails)
    {
        return dashboardDetailsMapper.selectDashboardDetailsList(dashboardDetails);
    }

    /**
     * 新增DashboardDetails
     * 
     * @param dashboardDetails DashboardDetails
     * @return 结果
     */
    @Override
    public int insertDashboardDetails(DashboardDetails dashboardDetails)
    {
        return dashboardDetailsMapper.insertDashboardDetails(dashboardDetails);
    }

    /**
     * 修改DashboardDetails
     * 
     * @param dashboardDetails DashboardDetails
     * @return 结果
     */
    @Override
    public int updateDashboardDetails(DashboardDetails dashboardDetails)
    {
        return dashboardDetailsMapper.updateDashboardDetails(dashboardDetails);
    }

    /**
     * 批量删除DashboardDetails
     * 
     * @param dashboardIds 需要删除的DashboardDetails主键
     * @return 结果
     */
    @Override
    public int deleteDashboardDetailsByDashboardIds(String[] dashboardIds)
    {
        return dashboardDetailsMapper.deleteDashboardDetailsByDashboardIds(dashboardIds);
    }

    /**
     * 删除DashboardDetails信息
     * 
     * @param dashboardId DashboardDetails主键
     * @return 结果
     */
    @Override
    public int deleteDashboardDetailsByDashboardId(String dashboardId)
    {
        return dashboardDetailsMapper.deleteDashboardDetailsByDashboardId(dashboardId);
    }
}
