package com.ballcat.blog.mapper;

import com.ballcat.blog.entity.BlogCategory;
import com.ballcat.blog.param.BlogCategoryParam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-07 22:02
 * @description
 */
@Mapper
public interface CategoryMapper extends BaseMapper<BlogCategory> {

    BlogCategory getByCategoryName(@Param("categoryName") String categoryName);

    List<BlogCategory> listBlogCategory(BlogCategoryParam param);

    void enabledBlogCategory(@Param("id") Long id, @Param("enabled") Boolean enabled);
}
