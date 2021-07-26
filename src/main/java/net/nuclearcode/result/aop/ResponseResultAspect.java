package net.nuclearcode.result.aop;

import net.nuclearcode.result.ResponseResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * aop解析注解
 *
 * @author zhaoxin
 * @date 2021年7月26日 15点48分
 */
@Aspect
@Component
public class ResponseResultAspect {

  /**
   * 定义@ResponseResult的切点
   */
  @Pointcut("@annotation(net.nuclearcode.result.annotation.RespResult)")
  public void responseResult() {}

  /**
   * doAround获取controller返回的值
   * @param joinPoint joinPoint
   * @return responseResult
   */
  @Around("responseResult()")
  public Object doAround(ProceedingJoinPoint joinPoint) {
    Object proceed = null;
    try {
      proceed = joinPoint.proceed();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    if (proceed instanceof ResponseResult) {
      return proceed;
    }

    return ResponseResult.build(proceed).success();
  }
}
