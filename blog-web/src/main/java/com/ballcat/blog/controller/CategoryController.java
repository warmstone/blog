package com.ballcat.blog.controller;

import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.common.validate.Update;
import com.ballcat.blog.dto.CategoryDTO;
import com.ballcat.blog.param.BlogCategoryParam;
import com.ballcat.blog.service.CategoryService;
import com.ballcat.blog.vo.CategoryVO;
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
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(value = "/category")
    @ApiOperation(value = "新增分类", httpMethod = "POST")
    public CommonResult<Integer> save(@RequestBody CategoryDTO categoryDTO) throws Exception {
        categoryService.saveBlogCategory(categoryDTO);
        return CommonResult.ok();
    }

    @PutMapping(value = "/category")
    @ApiOperation(value = "修改分类", httpMethod = "PUT")
    public CommonResult<Integer> update(@Validated(Update.class) @RequestBody CategoryDTO categoryDTO) throws Exception {
        categoryService.updateBlogCategory(categoryDTO);
        return CommonResult.ok();
    }

    @PutMapping(value = "/category/{id}")
    @ApiOperation(value = "启用/禁用分类", httpMethod = "DELETE")
    public CommonResult<Integer> enabled(@PathVariable("id") Long id, @RequestParam Boolean enabled) throws Exception {
        categoryService.enabled(id, enabled);
        return CommonResult.ok();
    }

    @GetMapping(value = "/category")
    @ApiOperation(value = "分类列表", httpMethod = "GET")
    public CommonResult<List<CategoryVO>> listBlogCategory(BlogCategoryParam param) {
        return categoryService.listBlogCategory(param);
    }

    @GetMapping(value = "/category/{id}")
    @ApiOperation(value = "查看分类详情", httpMethod = "GET")
    public CommonResult<CategoryVO> getById(@PathVariable("id") Long id) throws BizException {
        return CommonResult.ok(categoryService.getBlogCategoryById(id));
    }

}