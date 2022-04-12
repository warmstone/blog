package com.ballcat.blog.mapper;

import com.ballcat.blog.entity.LikeRecord;
import com.ballcat.blog.entity.ViewRecord;
import com.ballcat.blog.param.LikeRecordParam;
import com.ballcat.blog.param.ViewRecordParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-12 15:16
 * @description
 */
@Mapper
public interface LikeRecordMapper {
    /**
     * 查询点赞记录
     * @param param
     * @return
     */
    List<LikeRecord> listLikeRecord(LikeRecordParam param);
}
