package com.ballcat.blog.controller;

import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.common.validate.Update;
import com.ballcat.blog.dto.BlogCategoryDTO;
import com.ballcat.blog.entity.BlogCategory;
import com.ballcat.blog.param.BlogCategoryParam;
import com.ballcat.blog.service.BlogCategoryService;
import com.ballcat.blog.vo.BlogCategoryVO;
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
@AllArgsConstructor
@Api(tags = "后台管理>>博客分类管理")
public class BlogCategoryController {

    private final BlogCategoryService blogCategoryService;

    @PostMapping(value = "/blogCategory")
    @ApiOperation(value = "新增分类", httpMethod = "POST")
    public CommonResult<Integer> save(@RequestBody BlogCategoryDTO blogCategoryDTO) throws Exception {
        blogCategoryService.saveBlogCategory(blogCategoryDTO);
        return CommonResult.ok();
    }

    @PutMapping(value = "/blogCategory")
    @ApiOperation(value = "修改分类", httpMethod = "PUT")
    public CommonResult<Integer> update(@Validated(Update.class) @RequestBody BlogCategoryDTO blogCategoryDTO) throws Exception {
        blogCategoryService.updateBlogCategory(blogCategoryDTO);
        return CommonResult.ok();
    }

    @PutMapping(value = "/blogCategory/{id}")
    @ApiOperation(value = "启用/禁用分类", httpMethod = "DELETE")
    public CommonResult<Integer> enabled(@PathVariable("id") Long id, @RequestParam Boolean enabled) throws Exception {
        blogCategoryService.enabled(id, enabled);
        return CommonResult.ok();
    }

    @GetMapping(value = "/blogCategory")
    @ApiOperation(value = "分类列表", httpMethod = "GET")
    public CommonResult<List<BlogCategoryVO>> listBlogCategory(BlogCategoryParam param) {
        return blogCategoryService.listBlogCategory(param);
    }

    @GetMapping(value = "/blogCategory/{id}")
    @ApiOperation(value = "查看分类详情", httpMethod = "GET")
    public CommonResult<BlogCategoryVO> getById(@PathVariable("id") Long id) throws BizException {
        return CommonResult.ok(blogCategoryService.getBlogCategoryById(id));
    }

}
