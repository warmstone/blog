package com.ballcat.blog.service.impl;

import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.entity.ViewRecord;
import com.ballcat.blog.mapper.ViewRecordMapper;
import com.ballcat.blog.param.ViewRecordParam;
import com.ballcat.blog.service.ViewRecordService;
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
public class ViewRecordServiceImpl implements ViewRecordService {

    private final ViewRecordMapper viewRecordMapper;

    @Override
    public CommonResult<List<ViewRecord>> listViewRecord(ViewRecordParam param) {
        PageInfo<ViewRecord> pageInfo = PageHelper.startPage(param.getCurrentPage(), param.getPageSize()).doSelectPageInfo(() -> {
            viewRecordMapper.listViewRecord(param);
        });
        return CommonResult.ok(pageInfo.getList(), pageInfo.getTotal());
    }
}
