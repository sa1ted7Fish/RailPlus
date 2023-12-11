package com.ruoyi.project.railnet.data.service.impl;

import com.ruoyi.project.railnet.data.mapper.DataMapper;
import com.ruoyi.project.railnet.data.service.IDataService;
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
}
