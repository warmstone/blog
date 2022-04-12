package com.ballcat.blog.mapper;

import com.ballcat.blog.entity.ViewRecord;
import com.ballcat.blog.param.ViewRecordParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-12 15:16
 * @description
 */
@Mapper
public interface ViewRecordMapper {
    /**
     * 查询浏览记录
     * @param param
     * @return
     */
    List<ViewRecord> listViewRecord(ViewRecordParam param);
}
