package com.ballcat.blog.param;

import com.ballcat.blog.common.response.PageQuery;
import lombok.Data;

/**
 * @author pengshun
 * @date 2022-04-07 22:14
 * @description
 */
@Data
public class BlogCategoryParam extends PageQuery {

    private String categoryName;
}
