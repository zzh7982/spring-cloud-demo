package com.example.ribbon.service;

import com.example.ribbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * description: RibbonService
 *
 * @author zhangzh
 * @version [1.0, 2017/8/23]
 */
@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;

    public User getUserById(Long id) {
        return restTemplate.getForObject("http://provide-user/user/" + id, User.class);
    }
}
