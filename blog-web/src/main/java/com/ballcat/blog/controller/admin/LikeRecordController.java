package com.ballcat.blog.controller.admin;

import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.entity.LikeRecord;
import com.ballcat.blog.param.LikeRecordParam;
import com.ballcat.blog.service.LikeRecordService;
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
@Api(tags = "后台管理>>内容管理>>点赞记录")
@RequestMapping(value = "/admin/likeRecord")
@AllArgsConstructor
public class LikeRecordController {

    private final LikeRecordService likeRecordService;

    @GetMapping()
    @ApiOperation(value = "浏览记录列表", httpMethod = "GET")
    public CommonResult<List<LikeRecord>> listLikeRecord(@RequestParam(required = false) LikeRecordParam param) {
        return likeRecordService.listLikeRecord(param);
    }
}
