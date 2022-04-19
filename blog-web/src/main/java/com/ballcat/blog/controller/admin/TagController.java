package com.ballcat.blog.controller.admin;

import cn.hutool.core.util.ObjectUtil;
import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.common.validate.Update;
import com.ballcat.blog.dto.TagDTO;
import com.ballcat.blog.param.TagParam;
import com.ballcat.blog.service.TagService;
import com.ballcat.blog.vo.CategoryVO;
import com.ballcat.blog.vo.TagVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-07 22:05
 * @description
 */
@RestController
@RequestMapping(value = "/admin/tag")
@AllArgsConstructor
@Api(tags = "后台管理>>内容管理>>博客标签管理")
public class TagController {

    private final TagService tagService;

    @PostMapping()
    @ApiOperation(value = "新增标签", httpMethod = "POST")
    public CommonResult<Integer> save(@RequestBody TagDTO tagDTO) throws Exception {
        if (ObjectUtil.isNull(tagDTO.getId())) {
            tagService.saveBlogTag(tagDTO);
        } else {
            tagService.updateBlogTag(tagDTO);
        }
        return CommonResult.ok();
    }

    @PutMapping()
    @ApiOperation(value = "修改标签", httpMethod = "PUT")
    public CommonResult<Integer> update(@Validated(Update.class) @RequestBody TagDTO tagDTO) throws Exception {
        tagService.updateBlogTag(tagDTO);
        return CommonResult.ok();
    }

    @PutMapping(value = "/{id}/{enabled}")
    @ApiOperation(value = "启用/禁用标签", httpMethod = "PUT")
    public CommonResult<Integer> enabled(@PathVariable("id") Long id, @PathVariable("enabled") Boolean enabled) throws Exception {
        tagService.enabled(id, enabled);
        return CommonResult.ok();
    }

    @GetMapping()
    @ApiOperation(value = "标签列表", httpMethod = "GET")
    public CommonResult<List<TagVO>> listBlogTag(TagParam param) {
        return tagService.listBlogTag(param);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "查看标签详情", httpMethod = "GET")
    public CommonResult<TagVO> getById(@PathVariable("id") Long id) throws BizException {
        return CommonResult.ok(tagService.getBlogTagById(id));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "删除标签", httpMethod = "DELETE")
    public CommonResult<Integer> removeById(@PathVariable("id") Long id) throws Exception {
        tagService.removeTagById(id);
        return CommonResult.ok();
    }

    @GetMapping(value = "/all")
    @ApiOperation(value = "全部标签", httpMethod = "GET")
    public CommonResult<List<TagVO>> allTag() {
        return CommonResult.ok(tagService.allTag());
    }
}
