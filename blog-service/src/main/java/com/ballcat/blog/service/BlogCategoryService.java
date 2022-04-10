package com.ballcat.blog.service;

import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.dto.BlogCategoryDTO;
import com.ballcat.blog.entity.BlogCategory;
import com.ballcat.blog.param.BlogCategoryParam;
import com.ballcat.blog.vo.BlogCategoryVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-07 22:02
 * @description
 */
public interface BlogCategoryService extends IService<BlogCategory> {

    /**
     * 保存分类
     * @param blogCategoryDTO 要保存的分类
     */
    void saveBlogCategory(BlogCategoryDTO blogCategoryDTO) throws BizException;

    /**
     * 修改分类
     * @param blogCategoryDTO 要修改的分类
     */
    void updateBlogCategory(BlogCategoryDTO blogCategoryDTO) throws BizException;

    /**
     * 查看分类列表
     * @param param 查询入参
     * @return 分类列表
     */
    CommonResult<List<BlogCategoryVO>> listBlogCategory(BlogCategoryParam param);

    /**
     * 根据ID查询分类详情
     * @param id 分类ID
     * @return 分类详情
     */
    BlogCategoryVO getBlogCategoryById(Long id) throws BizException;

    /**
     * 启用/禁用分类
     * @param id 分类ID
     * @param enabled 启用状态
     */
    void enabled(Long id, Boolean enabled) throws BizException;
}
