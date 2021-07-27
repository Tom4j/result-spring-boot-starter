# result-spring-boot-starter #


----------

## 说明 ##

ResponseReulst是一个辅助工具类的,方便编码REST API时，返回统一格式：

    {"code":200,"message":"success","data":"test1"}

ResponseResult包含了三个部分：

1. code 状态码
2. message 说明
3. data 数据

code定义了五种状态：

1. SUCCESS -> 200
2. FAIL -> 400
3. UNAUTHORIZED -> 401
4. NOT_FOUND -> 404
5. INTERNAL_SERVER_ERROR -> 500

当然ResponseResult并不一定是你心中的理想型格式，但是它用起来真的很方便。

## 用法 ##

- 安装

maven坐标：

		<dependency>
			<groupId>io.github.dddinjava</groupId>
			<artifactId>result-spring-boot-starter</artifactId>
			<version>1.0.1</version>
		</dependency>
- 使用

方式一：

@RespResult,使用注解时，controller中的方法要返回值需是Object，代码如下：
```
/**
   * 用法1
   * @return obj
   */
  @RespResult
  @GetMapping("/")
  public Object index() {
    return "test1";
  }
```
返回JSON数据 -> {"code":200,"message":"success","data":"test1"}

方式二：


@RespResult自定义message，代码如下
```
/**
   * 用法2 自定义消息
   * @return obj
   */
  @RespResult(message = "我是自定义的消息")
  @GetMapping("/message")
  public Object message() {
    return "test1";
  }
```
返回JSON数据 -> {"code":200,"message":"我是自定义的消息","data":"test1"}

方式三：
代码中返回ResponseResult对象，代码如下：
```
/**
   * 用法3
   * @return obj
   */
  @GetMapping("/a")
  public ResponseResult index2() {
    //   return new ResponseResult<>(
    //        ResponseResultEnum.FAIL, ResponseResultEnum.FAIL.getMessage(), "ok");

    //    return new ResponseResult<>(
    //        ResponseResultEnum.SUCCESS, "ok");
    
    // return ResponseResult.build("aaa").fail()
    
    return ResponseResult.build("aaa").success();
  }
```
## 加入全局异常捕捉 ##

开启方式:

    spring.result.ex.enabled=true



