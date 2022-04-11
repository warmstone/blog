package com.ballcat.blog.param;

import com.ballcat.blog.common.response.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author pengshun
 * @date 2022-04-11 21:59
 * @description
 */
@Data
@ApiModel(description = "博客查询入参")
public class BlogParam extends PageQuery {

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("状态")
    private Integer state;

    @ApiModelProperty("分类")
    private Integer categoryId;

    @ApiModelProperty("创建起始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @ApiModelProperty("创建结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
