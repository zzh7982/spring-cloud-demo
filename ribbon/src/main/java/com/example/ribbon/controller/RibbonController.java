package com.example.ribbon.controller;

import com.example.ribbon.entity.User;
import com.example.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: RibbonController
 *
 * @author zhangzh
 * @version [1.0, 2017/8/23]
 */
@RestController
@RequestMapping("/ribbon/user")
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return ribbonService.getUserById(id);
    }
}
