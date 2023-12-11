package com.ruoyi.project.railplus.dv.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * API对象 rp_api
 * 
 * @author ruoyi
 * @date 2023-12-11
 */
public class Api extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String apiId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String apiName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String api;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String apiParams;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String method;

    public void setApiId(String apiId) 
    {
        this.apiId = apiId;
    }

    public String getApiId() 
    {
        return apiId;
    }
    public void setApiName(String apiName) 
    {
        this.apiName = apiName;
    }

    public String getApiName() 
    {
        return apiName;
    }
    public void setApi(String api) 
    {
        this.api = api;
    }

    public String getApi() 
    {
        return api;
    }
    public void setApiParams(String apiParams) 
    {
        this.apiParams = apiParams;
    }

    public String getApiParams() 
    {
        return apiParams;
    }
    public void setMethod(String method) 
    {
        this.method = method;
    }

    public String getMethod() 
    {
        return method;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("apiId", getApiId())
            .append("apiName", getApiName())
            .append("api", getApi())
            .append("apiParams", getApiParams())
            .append("method", getMethod())
            .toString();
    }
}
