package io.github.dddinjava.result;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 *
 * @author zhaoxin
 */
@Configuration
@ComponentScan(basePackages = {"io.github.dddinjava.result.aop", "io.github.dddinjava.result.advice"})
public class ResponseResultAutoConfiguration {}
