package com.ballcat.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.common.response.RetCode;
import com.ballcat.blog.dto.CategoryDTO;
import com.ballcat.blog.entity.BlogCategory;
import com.ballcat.blog.mapper.CategoryMapper;
import com.ballcat.blog.param.BlogCategoryParam;
import com.ballcat.blog.service.CategoryService;
import com.ballcat.blog.vo.CategoryVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pengshun
 * @date 2022-04-07 22:03
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, BlogCategory> implements CategoryService {

    private final CategoryMapper categoryMapper;

    /**
     * 保存分类
     * @param categoryDTO
     * @return
     */
    @Override
    public void saveBlogCategory(CategoryDTO categoryDTO) throws BizException {
        checkCategoryNameExists(categoryDTO.getCategoryName());
        BlogCategory blogCategory = new BlogCategory();
        BeanUtil.copyProperties(categoryDTO, blogCategory);
        save(blogCategory);
    }

    /**
     * 修改分类
     * @param categoryDTO 要修改的分类信息
     */
    @Override
    public void updateBlogCategory(CategoryDTO categoryDTO) throws BizException {
        // 查询分类是否存在
        checkCategoryExists(categoryDTO.getId());
        // 查询分类名称是否存在
        checkCategoryNameExists(categoryDTO.getCategoryName());
        BlogCategory updateEntity = new BlogCategory();
        BeanUtil.copyProperties(categoryDTO, updateEntity);
        updateById(updateEntity);
    }

    /**
     * 根据ID查询分类是否存在
     * @param id 分类ID
     */
    private BlogCategory checkCategoryExists(Long id) throws BizException {
        BlogCategory blogCategory = getById(id);
        if (ObjectUtil.isNull(blogCategory)) {
            throw new BizException(RetCode.NOT_FOUND);
        }
        return blogCategory;
    }

    /**
     * 校验分类名称是否存在
     * @param categoryName 分类名称
     */
    private void checkCategoryNameExists(String categoryName) throws BizException {
        BlogCategory category = categoryMapper.getByCategoryName(categoryName);
        if (ObjectUtil.isNotNull(category)) {
            throw new BizException("该分类已经存在");
        }
    }

    /**
     * 分页查询
     * @param param 查询入参
     * @return 博客分类列表
     */
    @Override
    public CommonResult<List<CategoryVO>> listBlogCategory(BlogCategoryParam param) {
        PageInfo<BlogCategory> pageInfo = PageHelper.startPage(param.getCurrentPage(), param.getPageSize()).doSelectPageInfo(() -> {
            categoryMapper.listBlogCategory(param);
        });
        List<BlogCategory> list = pageInfo.getList();
        List<CategoryVO> categoryVOList = list.stream().map(blogCategory -> {
            CategoryVO blogCategoryVO = new CategoryVO();
            BeanUtil.copyProperties(blogCategory, blogCategoryVO);
            return blogCategoryVO;
        }).collect(Collectors.toList());
        return CommonResult.ok(categoryVOList, pageInfo.getTotal());
    }

    /**
     * 根据ID查询分类详情
     * @param id 分类ID
     * @return 分类详情
     */
    @Override
    public CategoryVO getBlogCategoryById(Long id) throws BizException {
        BlogCategory blogCategory = checkCategoryExists(id);
        CategoryVO blogCategoryVO = new CategoryVO();
        BeanUtil.copyProperties(blogCategory, blogCategoryVO);
        return blogCategoryVO;
    }

    /**
     * 启用禁用分类
     * @param id 分类ID
     * @param enabled 启用状态
     */
    @Override
    public void enabled(Long id, Boolean enabled) throws BizException {
        checkCategoryExists(id);
        categoryMapper.enabledBlogCategory(id, enabled);
    }
}
