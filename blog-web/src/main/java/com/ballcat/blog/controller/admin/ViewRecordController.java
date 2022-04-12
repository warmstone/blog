package com.ballcat.blog.controller.admin;

import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.entity.ViewRecord;
import com.ballcat.blog.param.ViewRecordParam;
import com.ballcat.blog.service.ViewRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-12 15:28
 * @description
 */
@Api(tags = "后台管理>>内容管理>>浏览记录")
@RequestMapping(value = "/admin/viewRecord")
@AllArgsConstructor
public class ViewRecordController {

    private final ViewRecordService viewRecordService;

    @GetMapping()
    @ApiOperation(value = "浏览记录列表", httpMethod = "GET")
    public CommonResult<List<ViewRecord>> listViewRecord(@RequestParam(required = false) ViewRecordParam param) {
        return viewRecordService.listViewRecord(param);
    }
}
