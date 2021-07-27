package io.github.dddinjava.result.advice;

import io.github.dddinjava.result.ResponseResult;
import io.github.dddinjava.result.ResponseResultEnum;
import lombok.extern.java.Log;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author zhaoxin
 */
@Log
@RestControllerAdvice
@ConditionalOnProperty(prefix = "spring.result.ex", value = "enabled", matchIfMissing = true)
public class GlobalExceptionHandler {

  /**
   * 全局异常处理
   *
   * @param ex 异常
   * @return responseResult
   */
  @ExceptionHandler(value = Exception.class)
  public ResponseResult<String> exceptionHandler(Exception ex) {
    // 异常信息
    String exMessage = ex.getMessage();

    if (!StringUtils.hasLength(exMessage)) {
      exMessage = ex.toString();
    }

    log.warning(exMessage);

    return new ResponseResult<>(ResponseResultEnum.INTERNAL_SERVER_ERROR, exMessage, null);
  }
}
