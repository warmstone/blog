package com.ballcat.blog.service;

import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.entity.LikeRecord;
import com.ballcat.blog.param.LikeRecordParam;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-12 15:22
 * @description
 */
public interface LikeRecordService {

    /**
     * 查询点赞记录
     * @param param
     * @return
     */
    CommonResult<List<LikeRecord>> listLikeRecord(LikeRecordParam param);
}
