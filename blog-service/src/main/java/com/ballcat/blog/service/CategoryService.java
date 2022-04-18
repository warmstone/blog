package com.ballcat.blog.service;

import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.dto.CategoryDTO;
import com.ballcat.blog.entity.Category;
import com.ballcat.blog.param.CategoryParam;
import com.ballcat.blog.vo.CategoryVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-07 22:02
 * @description
 */
public interface CategoryService extends IService<Category> {

    /**
     * 保存分类
     * @param categoryDTO 要保存的分类
     */
    void saveBlogCategory(CategoryDTO categoryDTO) throws Exception;

    /**
     * 修改分类
     * @param categoryDTO 要修改的分类
     */
    void updateBlogCategory(CategoryDTO categoryDTO) throws Exception;

    /**
     * 查看分类列表
     * @param param 查询入参
     * @return 分类列表
     */
    CommonResult<List<CategoryVO>> listBlogCategory(CategoryParam param);

    /**
     * 根据ID查询分类详情
     * @param id 分类ID
     * @return 分类详情
     */
    CategoryVO getBlogCategoryById(Long id) throws BizException;

    /**
     * 启用/禁用分类
     * @param id 分类ID
     * @param enabled 启用状态
     */
    void enabled(Long id, Boolean enabled) throws BizException;

    /**
     * 删除分类
     * @param id
     */
    void removeCategoryById(Long id) throws BizException;

    /**
     * 所有分类
     * @return
     */
    List<CategoryVO> allCategory();

}
