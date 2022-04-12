package com.ballcat.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author pengshun
 * @date 2022-04-12 18:17
 * @description
 */
@Data
@ApiModel(description = "统计数据")
public class StatisticalDataVO {

    @ApiModelProperty("总阅读量")
    private Integer totalViewNum;

    @ApiModelProperty("昨日阅读量")
    private Integer yesterdayViewNum;

    @ApiModelProperty("上周阅读量")
    private Integer lastWeekViewNum;

    @ApiModelProperty("上月阅读量")
    private Integer lastMonthViewNum;

    @ApiModelProperty("昨天发布博客数")
    private Integer yesterdayBlogNum;

    @ApiModelProperty("发布博客总数")
    private Integer totalBlogNum;

    @ApiModelProperty("上周发布博客数")
    private Integer lastWeekBlogNum;

    @ApiModelProperty("上月发布博客数")
    private Integer lastMonthBlogNum;
}
