package io.github.dddinjava.result;

import java.io.Serializable;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

/**
 * 统一返回result对象
 *
 * @author zhaoxin
 * @date 2021年7月26日 13点37分
 */
@Getter
@ToString
public class ResponseResult<T> implements Serializable {

  private static final long serialVersionUID = -8463728693034303778L;

  /** 状态码 */
  private Integer code;

  /** 消息 */
  private String message;

  /** 数据 */
  private T data;

  /**
   * 成功响应
   *
   * @param message 消息
   * @param data 数据
   */
  public void success(String message, T data) {
    this.code = ResponseResultEnum.SUCCESS.getCode();
    this.message = message;
    this.data = data;
  }

  /**
   * 成功响应
   *
   * @param data 数据
   */
  public void success(T data) {
    this.success(ResponseResultEnum.SUCCESS.getMessage(), data);
  }

  /**
   * 获取ResponseResultHelper
   *
   * @param message 消息
   * @param <T> data
   * @return responseResultHelper
   */
  public static <T> ResponseResultHelper<T> build(String message, T data) {
    return new ResponseResultHelper<>(message, data);
  }

  /**
   * 获取ResponseResultHelper
   *
   * @param <T> data
   * @return responseResultHelper
   */
  public static <T> ResponseResultHelper<T> build(T data) {
    return new ResponseResultHelper<>(data);
  }

  /**
   * 失败响应
   *
   * @param message 消息
   * @param data 数据
   */
  public void fail(String message, T data) {
    this.code = ResponseResultEnum.FAIL.getCode();
    this.message = message;
    this.data = data;
  }

  /**
   * 失败响应
   *
   * @param data 数据
   */
  public void fail(T data) {
    this.success(ResponseResultEnum.FAIL.getMessage(), data);
  }

  /**
   * 有参构造函数
   *
   * @param responseResultEnum responseResultEnum
   * @param message 消息
   * @param data 数据
   */
  public ResponseResult(ResponseResultEnum responseResultEnum, String message, T data) {
    this.code = responseResultEnum.getCode();
    this.message = message;
    this.data = data;
  }

  /**
   * 有参构造函数
   *
   * @param responseResultEnum responseResultEnum
   * @param data 数据
   */
  public ResponseResult(ResponseResultEnum responseResultEnum, T data) {
    this.code = responseResultEnum.getCode();
    this.message = responseResultEnum.getMessage();
    this.data = data;
  }

  private ResponseResult() {}

  /** 静态内部类 */
  public static class ResponseResultHelper<T> {

    /** 消息 */
    private String message;

    /** 数据 */
    private final T data;

    /**
     * 成功响应
     *
     * @return responseResult
     */
    public ResponseResult<T> success() {
      ResponseResult<T> responseResult = new ResponseResult<>();
      if (StringUtils.hasLength(message)) {
        responseResult.success(message, data);
      } else {
        responseResult.success(data);
      }
      return responseResult;
    }

    /**
     * 失败响应
     *
     * @return responseResult
     */
    public ResponseResult<T> fail() {
      ResponseResult<T> responseResult = new ResponseResult<>();
      if (StringUtils.hasLength(message)) {
        responseResult.fail(message, data);
      } else {
        responseResult.fail(data);
      }
      return responseResult;
    }

    public ResponseResultHelper(T data) {
      this.data = data;
    }

    public ResponseResultHelper(String message, T data) {
      this.message = message;
      this.data = data;
    }
  }
}
