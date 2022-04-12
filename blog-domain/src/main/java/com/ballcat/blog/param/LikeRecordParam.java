package com.ballcat.blog.param;

import com.ballcat.blog.common.response.PageQuery;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author pengshun
 * @date 2022-04-12 15:25
 * @description
 */
@Data
@ApiModel(description = "点赞记录查询入参")
public class LikeRecordParam extends PageQuery {

    private String blogTitle;
}
