package com.ballcat.blog.service.impl;

import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.entity.LikeRecord;
import com.ballcat.blog.mapper.LikeRecordMapper;
import com.ballcat.blog.param.LikeRecordParam;
import com.ballcat.blog.service.LikeRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-12 15:23
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class LikeRecordServiceImpl implements LikeRecordService {

    private final LikeRecordMapper likeRecordMapper;

    @Override
    public CommonResult<List<LikeRecord>> listLikeRecord(LikeRecordParam param) {
        PageInfo<LikeRecord> pageInfo = PageHelper.startPage(param.getCurrentPage(), param.getPageSize()).doSelectPageInfo(() -> {
            likeRecordMapper.listLikeRecord(param);
        });
        return CommonResult.ok(pageInfo.getList(), pageInfo.getTotal());
    }
}
