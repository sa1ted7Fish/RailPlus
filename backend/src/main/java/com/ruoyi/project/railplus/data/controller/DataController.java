package com.ruoyi.project.railnet.data.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Anonymous;
import com.ruoyi.project.railnet.data.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Anonymous
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private IDataService dataService;

    @GetMapping("/r")
    public List<Map<String, Object>> rental(@RequestParam("date") String date) {
        return dataService.selectRentalByDate(date);
    }

    @GetMapping("/lp")
    public List<Map<String, Object>> languagePercentage(@RequestParam("country") String country) {
        return dataService.selectLanguagePercentageByCountry(country);
    }
}
