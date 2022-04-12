package com.ballcat.blog.mapper;

import com.ballcat.blog.entity.BlogTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author pengshun
 * @date 2022-04-12 10:18
 * @description
 */
@Mapper
public interface BlogTagMapper extends BaseMapper<BlogTag> {

    /**
     * 删除博客标签
     * @param blogId
     */
    void removeByBlogId(@Param("blogId") Long blogId);
}
