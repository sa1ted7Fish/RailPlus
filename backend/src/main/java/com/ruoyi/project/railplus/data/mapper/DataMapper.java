package com.ruoyi.project.railnet.data.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataMapper {

    public List<Map<String, Object>> selectRentalByDate(String date);

    public List<Map<String, Object>> selectLanguagePercentageByCountry(String country);
}
