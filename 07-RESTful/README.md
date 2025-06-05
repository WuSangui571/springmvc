# RESTFul编程风格

## RESTFul是什么

RESTFul是`WEB服务接口`的一种设计风格。
RESTFul定义了一组约束条件和规范，可以让`WEB服务接口`更加简洁、易于理解、易于扩展、安全可靠。

RESTFul对一个`WEB服务接口`都规定了哪些东西？

- 对请求的URL格式有约束和规范
- 对HTTP的请求方式有约束和规范
- 对请求和响应的数据格式有约束和规范
- 对HTTP状态码有约束和规范
- 等 ......

REST对请求方式的约束是这样的：

- 查询必须发送GET请求
- 新增必须发送POST请求
- 修改必须发送PUT请求
- 删除必须发送DELETE请求

REST对URL的约束是这样的：

- 传统的URL：get请求，/springmvc/getUserById?id=1
- REST风格的URL：get请求，/springmvc/user/1

- 传统的URL：get请求，/springmvc/deleteUserById?id=1
- REST风格的URL：delete请求, /springmvc/user/1

RESTFul对URL的约束和规范的核心是：**通过采用**`**不同的请求方式**`**+ **`**URL**`**来确定WEB服务中的资源。**

**RESTful 的英文全称是 Representational State Transfer（表述性状态转移）。简称REST。**
表述性（Representational）是：URI + 请求方式。
状态（State）是：服务器端的数据。
转移（Transfer）是：变化。
表述性状态转移是指：通过 URI + 请求方式 来控制服务器端数据的变化。

## RESTFul风格与传统方式对比

传统的 URL 与 RESTful URL 的区别是传统的 URL 是基于方法名进行资源访问和操作，而 RESTful URL 是基于资源的结构和状态进行操作的。下面是一张表格，展示两者之间的具体区别：

| **传统的 URL**           | **RESTful URL** |
| ------------------------ | --------------- |
| GET /getUserById?id=1    | GET /user/1     |
| GET /getAllUser          | GET /user       |
| POST /addUser            | POST /user      |
| POST /modifyUser         | PUT /user       |
| GET /deleteUserById?id=1 | DELETE /user/1  |

从上表中我们可以看出，传统的URL是基于动作的，而 RESTful URL 是基于资源和状态的，因此 RESTful URL 更加清晰和易于理解，这也是 REST 架构风格被广泛使用的主要原因之一。

## RESTFul方式演示查询

RESTFul规范中规定，如果要查询数据，需要发送GET请求。

### 根据id查询(GET /api/user/1)

首页index.html

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
    <h1>首页</h1>
    <a th:href="@{/user/1}">查看用户id=1的信息</a>
</body>
</html>
```

控制器Controller：

```java
package com.sangui.springmvc.controller;


import com.sangui.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-05
 * @Description:
 * @Version: 1.0
 */
@Controller
public class UserController {
 // 查询操作，在postman里选择none即可
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public ModelAndView getOne(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","id= " + id + "的user查询中......");
        modelAndView.setViewName("ok");
        return modelAndView;
    }
}
```



视图页面：

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>操作成功</title>
</head>
<body>
    <h1>ok!</h1>
    <div th:text="${msg}"></div>
</body>
</html>
```

启动服务器，测试：http://localhost:8080/springmvc

页面显示：user查询所有结果中......

### 查询所有(GET /api/user)

```html
<!--查询所有-->
<a th:href="@{/user}">查看用户list</a>
```

```java
// 查询操作，在postman里选择none即可
@RequestMapping(value = "/user",method = RequestMethod.GET)
public ModelAndView getAll(){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("msg","user查询所有结果中......");
    modelAndView.setViewName("ok");
    return modelAndView;
}
```

启动服务器测试：
页面显示：id= 1的user查询中......

## RESTFul方式演示增加(POST /api/user)

RESTFul规范中规定，如果要进行保存操作，需要发送POST请求。

```html
增加操作。在postman里选择 POST 以及 x-www-form-urlencoded
```

```java
@RequestMapping(value = "/user",method = RequestMethod.POST)
public ModelAndView addOne(User user){
    ModelAndView modelAndView = new ModelAndView();
    System.out.println("user:" + user+ "add......");
    modelAndView.addObject("msg","user:" + user+ "add......");
    modelAndView.setViewName("ok");
    return modelAndView;
}
```

启动服务器在postman中测试：http://localhost:8080/springmvc/user
输出结果：user:User(username=zhangsan, password=11111)add......

## RESTFul方式演示修改

RESTFul规范中规定，如果要进行保存操作，需要发送PUT请求。

```
修改操作。在postman里选择Body->raw->JSON，写json格式： {"username": "zhangsan","password": "222"}
注意添加jackson-databind依赖，和在方法输入参数里写上@RequestBody注解
```

```java
@RequestMapping(value = "/user",method = RequestMethod.PUT)
public ModelAndView updateOne(@RequestBody User user){
    ModelAndView modelAndView = new ModelAndView();
    System.out.println("new user:" + user + "is update......");
    modelAndView.addObject("msg","new user:" + user + "is update......");
    modelAndView.setViewName("ok");
    return modelAndView;
}
```

启动服务器在postman中使用PUT和raw的json测试测试：http://localhost:8080/springmvc/user

输出结果：new user:User(username=11111, password=21122)is update......

## RESTFul方式演示删除

RESTFul规范中规定，如果要进行保存操作，需要发送DELETE请求。

```java
// 删除操作在postman里选择none即可
@RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
public ModelAndView deleteOne(@PathVariable("id") String id,User user){
    ModelAndView modelAndView = new ModelAndView();
    System.out.println("user:" + id + "is delete......");
    modelAndView.addObject("msg","user:" + id+ "is delete......");
    modelAndView.setViewName("ok");
    return modelAndView;
}
```

启动服务器在postman中使用POST选择none测试：http://localhost:8080/springmvc/user/1

输出结果：user:1is delete......



