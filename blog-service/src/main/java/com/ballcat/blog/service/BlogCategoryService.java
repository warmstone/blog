package com.ballcat.blog.service;

import com.ballcat.blog.dto.BlogCategoryDTO;
import com.ballcat.blog.entity.BlogCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author pengshun
 * @date 2022-04-07 22:02
 * @description
 */
public interface BlogCategoryService extends IService<BlogCategory> {

    /**
     * 保存分类
     * @param blogCategoryDTO
     * @return
     */
    Integer saveBlogCategory(BlogCategoryDTO blogCategoryDTO);

}
