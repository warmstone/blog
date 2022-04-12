package com.ballcat.blog.service;

import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.entity.ViewRecord;
import com.ballcat.blog.param.ViewRecordParam;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-12 15:22
 * @description
 */
public interface ViewRecordService {

    /**
     * 查询浏览记录
     * @param param
     * @return
     */
    CommonResult<List<ViewRecord>> listViewRecord(ViewRecordParam param);
}
