package com.example.hystrix.controller;

import com.example.hystrix.entity.User;
import com.example.hystrix.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: HystrixController
 *
 * @author zhangzh
 * @version [1.0, 2017/8/23]
 */
@RestController
@RequestMapping("/hystrix/user")
public class HystrixController {
    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return hystrixService.getUserById(id);
    }
}
