package com.ruoyi.project.railplus.dv.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.railplus.dv.domain.Api;
import com.ruoyi.project.railplus.dv.service.IApiService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * APIController
 * 
 * @author ruoyi
 * @date 2023-12-11
 */
@RestController
@RequestMapping("/dv/api")
public class ApiController extends BaseController
{
    @Autowired
    private IApiService apiService;

    /**
     * 查询API列表
     */
    @PreAuthorize("@ss.hasPermi('dv:api:list')")
    @GetMapping("/list")
    public TableDataInfo list(Api api)
    {
        startPage();
        List<Api> list = apiService.selectApiList(api);
        return getDataTable(list);
    }

    /**
     * 导出API列表
     */
    @PreAuthorize("@ss.hasPermi('dv:api:export')")
    @Log(title = "API", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Api api)
    {
        List<Api> list = apiService.selectApiList(api);
        ExcelUtil<Api> util = new ExcelUtil<Api>(Api.class);
        util.exportExcel(response, list, "API数据");
    }

    /**
     * 获取API详细信息
     */
    @PreAuthorize("@ss.hasPermi('dv:api:query')")
    @GetMapping(value = "/{apiId}")
    public AjaxResult getInfo(@PathVariable("apiId") String apiId)
    {
        return success(apiService.selectApiByApiId(apiId));
    }

    /**
     * 新增API
     */
    @PreAuthorize("@ss.hasPermi('dv:api:add')")
    @Log(title = "API", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Api api)
    {
        return toAjax(apiService.insertApi(api));
    }

    /**
     * 修改API
     */
    @PreAuthorize("@ss.hasPermi('dv:api:edit')")
    @Log(title = "API", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Api api)
    {
        return toAjax(apiService.updateApi(api));
    }

    /**
     * 删除API
     */
    @PreAuthorize("@ss.hasPermi('dv:api:remove')")
    @Log(title = "API", businessType = BusinessType.DELETE)
	@DeleteMapping("/{apiIds}")
    public AjaxResult remove(@PathVariable String[] apiIds)
    {
        return toAjax(apiService.deleteApiByApiIds(apiIds));
    }
}
