package com.ballcat.blog.controller.admin;

import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.entity.Blog;
import com.ballcat.blog.param.BlogParam;
import com.ballcat.blog.service.BlogService;
import com.ballcat.blog.vo.BlogVO;
import com.ballcat.blog.vo.detail.BlogDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private BlogService blogService;

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
}
