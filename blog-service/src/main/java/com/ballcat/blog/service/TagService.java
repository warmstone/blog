package com.ballcat.blog.service;

import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.dto.TagDTO;
import com.ballcat.blog.entity.Tag;
import com.ballcat.blog.param.TagParam;
import com.ballcat.blog.vo.CategoryVO;
import com.ballcat.blog.vo.TagVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-07 22:02
 * @description
 */
public interface TagService extends IService<Tag> {

    /**
     * 保存标签
     * @param tagDTO 要保存的标签
     */
    void saveBlogTag(TagDTO tagDTO) throws BizException;

    /**
     * 修改标签
     * @param tagDTO 要修改的标签
     */
    void updateBlogTag(TagDTO tagDTO) throws BizException;

    /**
     * 查看标签列表
     * @param param 查询入参
     * @return 标签列表
     */
    CommonResult<List<TagVO>> listBlogTag(TagParam param);

    /**
     * 根据ID查询标签详情
     * @param id 标签ID
     * @return 标签详情
     */
    TagVO getBlogTagById(Long id) throws BizException;

    /**
     * 启用/禁用标签
     * @param id 标签ID
     * @param enabled 启用状态
     */
    void enabled(Long id, Boolean enabled) throws BizException;

    /**
     * 删除标签
     * @param id
     */
    void removeTagById(Long id) throws BizException;

    /**
     * 所有标签
     * @return
     */
    List<TagVO> allTag();
}
