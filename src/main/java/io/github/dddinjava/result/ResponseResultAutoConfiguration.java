package io.github.dddinjava.result;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 自动配置类
 *
 * @author zhaoxin
 */
@Configuration
@ComponentScan(basePackages = {"io.github.dddinjava.result.aop"})
@Import(GlobalExceptionAutoConfiguration.class)
public class ResponseResultAutoConfiguration {}
