package io.github.dddinjava.result;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;

/**
 * 全局异常
 *
 * @author zhaoxin
 */
@ConditionalOnProperty(prefix = "spring.result.ex", name = "enabled", havingValue = "true")
@ComponentScan(basePackages = {"io.github.dddinjava.result.advice"})
public class GlobalExceptionAutoConfiguration {}
