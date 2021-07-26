package io.github.dddinjava.result;

import lombok.Getter;

/**
 * ResponseResult-code 状态码
 *
 * @author zhaoxin
 * @date 2021年7月26日 13点16分
 */
@Getter
public enum ResponseResultEnum {

  // 成功
  SUCCESS(200, "success"),

  // 失败
  FAIL(400, "fail"),

  // 未认证（签名错误）
  UNAUTHORIZED(401, "unauthorized"),

  // 不存在
  NOT_FOUND(404, "not_found"),

  // 服务器内部错误
  INTERNAL_SERVER_ERROR(500, "internal_server_error");

  /** code */
  private final Integer code;

  /** message */
  private final String message;

  ResponseResultEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}
