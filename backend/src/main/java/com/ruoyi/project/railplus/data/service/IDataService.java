package com.ruoyi.project.railplus.data.service;

import java.util.List;
import java.util.Map;

public interface IDataService {

    public List<Map<String, Object>> selectRentalByDate(String date);

    public List<Map<String, Object>> selectLanguagePercentageByCountry(String country);

    public List<Map<String, Object>> selectCityPopulationTop10();
}
