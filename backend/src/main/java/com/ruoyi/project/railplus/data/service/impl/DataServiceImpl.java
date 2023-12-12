package com.ruoyi.project.railplus.data.service.impl;

import com.ruoyi.project.railplus.data.mapper.DataMapper;
import com.ruoyi.project.railplus.data.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataServiceImpl implements IDataService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public List<Map<String, Object>> selectRentalByDate(String date) {
        return dataMapper.selectRentalByDate(date);
    }

    @Override
    public List<Map<String, Object>> selectLanguagePercentageByCountry(String country) {
        return dataMapper.selectLanguagePercentageByCountry(country);
    }

    @Override
    public List<Map<String, Object>> selectCityPopulationTop10() {
        return dataMapper.selectCityPopulationTop10();
    }
}
