package net.nuclearcode.result.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义@ResponseResult注解
 * @author zhaoxin
 * @date 2021年7月26日 15点51分
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RespResult {

  /**
   * 默认消息
   */
  String message() default "";

}
