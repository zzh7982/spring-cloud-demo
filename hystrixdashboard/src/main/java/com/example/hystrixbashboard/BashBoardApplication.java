package com.example.hystrixbashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * description: BashBordApplication
 *
 * @author zhangzh
 * @version [1.0, 2017/8/23]
 */

/**
 * 测试步骤:
 * 1. 访问http://localhost:8030/hystrix.stream 可以查看Dashboard
 * 2. 在上面的输入框填入: http://想监控的服务:端口/hystrix.stream进行测
 * 试 *
 * 注意：首先要先调用一下想监控的服务的API，否则将会显示一个空的图表.
 */
@SpringBootApplication
@EnableHystrixDashboard
public class BashBoardApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BashBoardApplication.class).web(true).run(args);
    }
}
