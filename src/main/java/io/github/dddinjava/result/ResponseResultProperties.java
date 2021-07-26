package io.github.dddinjava.result;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 配置
 * @author zhaoxin
 * @date 2021年7月26日 13点12分
 */
@EnableConfigurationProperties(ResponseResultProperties.class)
@ConfigurationProperties(prefix = "response.result")
public class ResponseResultProperties {

}
