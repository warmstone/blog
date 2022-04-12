package com.ballcat.blog.controller.admin;

import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.common.validate.Update;
import com.ballcat.blog.dto.BlogDTO;
import com.ballcat.blog.entity.Blog;
import com.ballcat.blog.param.BlogParam;
import com.ballcat.blog.service.BlogService;
import com.ballcat.blog.vo.BlogVO;
import com.ballcat.blog.vo.detail.BlogDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-11 22:41
 * @description
 */
@RestController
@RequestMapping(value = "/admin/blog")
@Api(tags = "后台管理>>博客管理")
@AllArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping()
    @ApiOperation(value = "博客列表", httpMethod = "GET")
    public CommonResult<List<BlogVO>> listBlog(BlogParam blogParam) throws Exception {
        return blogService.listBlog(blogParam);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "博客详情", httpMethod = "GET")
    public CommonResult<BlogDetailVO> getById(@PathVariable("id") Long id) throws Exception {
        return CommonResult.ok(blogService.getBlogById(id));
    }

    @PostMapping()
    @ApiOperation(value = "保存/发布博客", httpMethod = "POST")
    public CommonResult<Integer> saveBlog(@Validated @RequestBody BlogDTO blogDTO) throws Exception {
        blogService.saveBlog(blogDTO);
        return CommonResult.ok();
    }

    @PutMapping()
    @ApiOperation(value = "修改博客", httpMethod = "PUT")
    public CommonResult<Integer> updateBlog(@Validated(Update.class) @RequestBody BlogDTO blogDTO) throws Exception {
        blogService.updateBlog(blogDTO);
        return CommonResult.ok();
    }
}
