package com.ballcat.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pengshun
 * @date 2022-04-06 22:31
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/healthCheck")
public class HealthCheckController {

    @GetMapping(value = "/ok")
    public String hello() {
        int i = 1 / 0;
       return "I'm ok";
    }
}
