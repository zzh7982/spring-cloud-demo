package com.example.hystrix.service;

import com.example.hystrix.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * description: HystrixService
 *
 * @author zhangzh
 * @version [1.0, 2017/8/23]
 */
@Service
public class HystrixService {
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixService.class);

    @HystrixCommand(fallbackMethod = "fallback")
    public User getUserById(Long id){
        return restTemplate.getForObject("http://provide-user/user/" + id, User.class);

    }

    private User fallback(Long id){
        LOGGER.info("进入fallback，id:{}",id);
        return new User(-1L,"default",0);
    }
}
