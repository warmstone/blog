package com.ballcat.blog.controller.admin;

import com.ballcat.blog.service.StatisticalDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengshun
 * @date 2022-04-12 18:10
 * @description
 */
@RequestMapping("/statistical/data")
@RestController
@AllArgsConstructor
public class StatisticalDataController {

    private final StatisticalDataService statisticalDataService;


}
