package io.github.dddinjava.result;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 配置
 * @author zhaoxin
 */
@EnableConfigurationProperties(ResponseResultProperties.class)
@ConfigurationProperties(prefix = "response.result")
public class ResponseResultProperties {

}
