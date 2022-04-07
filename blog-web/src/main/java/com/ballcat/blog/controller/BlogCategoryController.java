package com.ballcat.blog.controller;

import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.common.validate.Update;
import com.ballcat.blog.dto.BlogCategoryDTO;
import com.ballcat.blog.entity.BlogCategory;
import com.ballcat.blog.param.BlogCategoryParam;
import com.ballcat.blog.service.BlogCategoryService;
import com.ballcat.blog.vo.BlogCategoryVO;
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
public class BlogCategoryController {

    private final BlogCategoryService blogCategoryService;

    @PostMapping(value = "/blogCategory")
    public CommonResult<Integer> save(@RequestBody BlogCategoryDTO blogCategoryDTO) {
        return CommonResult.ok(blogCategoryService.saveBlogCategory(blogCategoryDTO));
    }

    @PutMapping(value = "/blogCategory")
    public CommonResult<Integer> update(@Validated(Update.class) @RequestBody BlogCategoryDTO blogCategoryDTO) {
        return CommonResult.ok();
    }

    @GetMapping(value = "/blogCategory")
    public CommonResult<List<BlogCategoryVO>> listBlogCategory(BlogCategoryParam param) {
        return CommonResult.ok();
    }

    @GetMapping(value = "/blogCategory/{id}")
    public CommonResult<BlogCategoryVO> getById(@PathVariable("id") Long id) {
        return CommonResult.ok();
    }


}
