package com.uwjx.springmvc.caffeine;

import com.uwjx.springmvc.dal.entity.CaffeineUser;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "caffeine")
public class CaffeineController {

    @Resource
    CaffeineService caffeineService;

    @GetMapping
    public List<CaffeineUser> get(@RequestParam("id") Integer id)
    {
        return caffeineService.get();
    }

    @GetMapping(value = "findById")
    public CaffeineUser findById(@RequestParam("id") Integer id)
    {
        return caffeineService.findById(id);
    }
}
