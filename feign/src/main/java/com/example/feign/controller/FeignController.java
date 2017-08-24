package com.example.feign.controller;

import com.example.feign.entity.User;
import com.example.feign.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: FeignController
 *
 * @author zhangzh
 * @version [1.0, 2017/8/23]
 */
@RestController
public class FeignController {
    @Autowired
    private UserFeignClient feignClient;

    @GetMapping("/feign/user/{id}")
    public User getUserById(@PathVariable Long id){
        return feignClient.getUserById(id);
    }
}
