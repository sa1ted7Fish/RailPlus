package com.ruoyi.project.railplus.dv.mapper;

import java.util.List;
import com.ruoyi.project.railplus.dv.domain.Api;

/**
 * APIMapper接口
 * 
 * @author ruoyi
 * @date 2023-12-11
 */
public interface ApiMapper 
{
    /**
     * 查询API
     * 
     * @param apiId API主键
     * @return API
     */
    public Api selectApiByApiId(String apiId);

    /**
     * 查询API列表
     * 
     * @param api API
     * @return API集合
     */
    public List<Api> selectApiList(Api api);

    /**
     * 新增API
     * 
     * @param api API
     * @return 结果
     */
    public int insertApi(Api api);

    /**
     * 修改API
     * 
     * @param api API
     * @return 结果
     */
    public int updateApi(Api api);

    /**
     * 删除API
     * 
     * @param apiId API主键
     * @return 结果
     */
    public int deleteApiByApiId(String apiId);

    /**
     * 批量删除API
     * 
     * @param apiIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApiByApiIds(String[] apiIds);
}
