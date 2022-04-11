package com.ballcat.blog.mapper;

import com.ballcat.blog.entity.Tag;
import com.ballcat.blog.param.TagParam;
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
public interface TagMapper extends BaseMapper<Tag> {

    Tag getByTagName(@Param("TagName") String tagName);

    List<Tag> listBlogTag(TagParam param);

    void enabledBlogTag(@Param("id") Long id, @Param("enabled") Boolean enabled);
}
