package com.example.feign.feign;

import com.example.feign.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description: UserFeignClient
 *
 * @author zhangzh
 * @version [1.0, 2017/8/23]
 */
@FeignClient(name = "provide-user",fallback = UserFeignClient.UserFeignClientHystrix.class)
public interface UserFeignClient {
    @RequestMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id);

    /**
     * 这边采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
     */
    @Component
    static class UserFeignClientHystrix implements UserFeignClient{
        private static final Logger LOGGER = LoggerFactory.getLogger(UserFeignClientHystrix.class);
        @Override
        public User getUserById(Long id) {
            LOGGER.info("进入fallback，id:{}",id);
            return new User(-1L,"default",0);
        }
    }
}
