package com.ballcat.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.common.response.RetCode;
import com.ballcat.blog.entity.Blog;
import com.ballcat.blog.entity.Category;
import com.ballcat.blog.mapper.BlogMapper;
import com.ballcat.blog.param.BlogParam;
import com.ballcat.blog.service.BlogService;
import com.ballcat.blog.service.CategoryService;
import com.ballcat.blog.vo.BlogVO;
import com.ballcat.blog.vo.detail.BlogDetailVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author pengshun
 * @date 2022-04-11 22:21
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    private final BlogMapper blogMapper;

    private final CategoryService categoryService;

    /**
     * 查询博客详情
     * @param id 博客ID
     * @return 博客详情
     */
    @Override
    public BlogDetailVO getBlogById(Long id) throws BizException {
        Blog blog = checkBlogExists(id);
        BlogDetailVO blogDetailVO = new BlogDetailVO();
        BeanUtil.copyProperties(blog, blogDetailVO);
        return blogDetailVO;
    }

    /**
     * 查询博客列表
     * @param param 查询入参
     * @return 博客列表
     */
    @Override
    public CommonResult<List<BlogVO>> listBlog(BlogParam param) {
        PageInfo<Blog> pageInfo = PageHelper.startPage(param.getCurrentPage(), param.getPageSize()).doSelectPageInfo(() -> {
            blogMapper.listBlog(param);
        });
        List<BlogVO> blogVOList = pageInfo.getList().stream().map(blog -> {
            BlogVO blogVO = new BlogVO();
            BeanUtil.copyProperties(blog, blogVO);
            // 查询博客分类
            String categoryName = Optional.ofNullable(categoryService.getById(blog.getCategoryId())).map(Category::getCategoryName).orElse(null);
            blogVO.setCategoryName(categoryName);
            return blogVO;
        }).collect(Collectors.toList());
        return CommonResult.ok(blogVOList, pageInfo.getTotal());
    }

    private Blog checkBlogExists(Long id) throws BizException {
        Blog blog = getById(id);
        if (ObjectUtil.isNull(blog)) {
            throw new BizException(RetCode.NOT_FOUND);
        }
        return blog;
    }
}
