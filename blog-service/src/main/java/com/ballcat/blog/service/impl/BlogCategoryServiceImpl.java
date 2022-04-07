package com.ballcat.blog.service.impl;

import com.ballcat.blog.dto.BlogCategoryDTO;
import com.ballcat.blog.entity.BlogCategory;
import com.ballcat.blog.mapper.BlogCategoryMapper;
import com.ballcat.blog.service.BlogCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author pengshun
 * @date 2022-04-07 22:03
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements BlogCategoryService {

    private final BlogCategoryMapper blogCategoryMapper;

    /**
     * 保存分类
     * @param blogCategoryDTO
     * @return
     */
    @Override
    public Integer saveBlogCategory(BlogCategoryDTO blogCategoryDTO) {
        boolean categoryExists = checkBlogCategoryExists(blogCategoryDTO.getCategoryName());
        return null;
    }

    /**
     * 校验分类是否存在
     * @param categoryName 分类名称
     */
    private boolean checkBlogCategoryExists(String categoryName) {

        return false;
    }
}
