package io.github.dddinjava.result.aop;

import io.github.dddinjava.result.annotation.RespResult;
import io.github.dddinjava.result.ResponseResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * aop解析注解
 *
 * @author zhaoxin
 */
@Aspect
@Component
public class ResponseResultAspect {

  /** 定义@ResponseResult的切点 */
  @Pointcut("@annotation(io.github.dddinjava.result.annotation.RespResult)")
  public void responseResult() {}

  /**
   * doAround获取controller返回的值
   *
   * @param joinPoint joinPoint
   * @return responseResult
   */
  @Around("responseResult() && @annotation(respResult)")
  public Object doAround(ProceedingJoinPoint joinPoint, RespResult respResult) throws Throwable {
    Object proceed = joinPoint.proceed();

    if (proceed instanceof ResponseResult) {
      return proceed;
    }

    // message
    String message = respResult.message();

    if (StringUtils.hasLength(message)) {
      return ResponseResult.build(message, proceed).success();
    }
    return ResponseResult.build(proceed).success();
  }
}
