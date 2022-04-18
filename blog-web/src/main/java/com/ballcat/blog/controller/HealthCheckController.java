package com.ballcat.blog.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author pengshun
 * @date 2022-04-06 22:31
 * @description
 */
@Slf4j
@Api(tags = "健康检查")
@RestController
@RequestMapping("/healthCheck")
public class HealthCheckController {

    @GetMapping(value = "/ok")
    @ApiOperation(value = "健康检查", httpMethod = "GET")
    public String hello() {
       return "I'm ok";
    }

    @PostMapping(value = "/testLogAspect")
    @ApiOperation(value = "测试日志切面", httpMethod = "POST")
    public String testLogAspect(@RequestBody Map<String, Object> params) {
        JSONObject jsonObject = JSONUtil.parseObj(params);
        return jsonObject.toString();
    }

    @GetMapping(value = "/user")
    public CommonResult<User> getUser() {
        User user = new User();
        user.setId(1L);
        user.setCreateTime(new Date());
        return CommonResult.ok(user);
    }
}
