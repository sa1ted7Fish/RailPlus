package com.ruoyi.project.railplus.dv.service.impl;

import java.util.List;

import com.ruoyi.common.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.railplus.dv.mapper.ApiMapper;
import com.ruoyi.project.railplus.dv.domain.Api;
import com.ruoyi.project.railplus.dv.service.IApiService;

/**
 * APIService业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-11
 */
@Service
public class ApiServiceImpl implements IApiService 
{
    @Autowired
    private ApiMapper apiMapper;

    /**
     * 查询API
     * 
     * @param apiId API主键
     * @return API
     */
    @Override
    public Api selectApiByApiId(String apiId)
    {
        return apiMapper.selectApiByApiId(apiId);
    }

    /**
     * 查询API列表
     * 
     * @param api API
     * @return API
     */
    @Override
    public List<Api> selectApiList(Api api)
    {
        return apiMapper.selectApiList(api);
    }

    /**
     * 新增API
     * 
     * @param api API
     * @return 结果
     */
    @Override
    public int insertApi(Api api)
    {
        String apiId = UUID.fastUUID().toString();
        api.setApiId(apiId);
        return apiMapper.insertApi(api);
    }

    /**
     * 修改API
     * 
     * @param api API
     * @return 结果
     */
    @Override
    public int updateApi(Api api)
    {
        return apiMapper.updateApi(api);
    }

    /**
     * 批量删除API
     * 
     * @param apiIds 需要删除的API主键
     * @return 结果
     */
    @Override
    public int deleteApiByApiIds(String[] apiIds)
    {
        return apiMapper.deleteApiByApiIds(apiIds);
    }

    /**
     * 删除API信息
     * 
     * @param apiId API主键
     * @return 结果
     */
    @Override
    public int deleteApiByApiId(String apiId)
    {
        return apiMapper.deleteApiByApiId(apiId);
    }
}
