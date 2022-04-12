package com.ballcat.blog.service;

import com.ballcat.blog.entity.BlogTag;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author pengshun
 * @date 2022-04-12 10:18
 * @description
 */
public interface BlogTagService extends IService<BlogTag> {
    /**
     * 删除博客的标签
     * @param id
     */
    void removeByBlogId(Long id);
}
