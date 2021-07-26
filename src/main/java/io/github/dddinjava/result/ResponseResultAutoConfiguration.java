package io.github.dddinjava.result;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 *
 * @author zhaoxin
 * @date 2021年7月26日 13点06分
 */
@Configuration
@ComponentScan(basePackages = {"io.github.dddinjava.result.aop"})
public class ResponseResultAutoConfiguration {}
