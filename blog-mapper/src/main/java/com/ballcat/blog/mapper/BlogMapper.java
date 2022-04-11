package com.ballcat.blog.mapper;

import com.ballcat.blog.entity.Blog;
import com.ballcat.blog.param.BlogParam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-11 21:58
 * @description
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    List<Blog> listBlog(BlogParam param);
}
