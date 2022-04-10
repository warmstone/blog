package com.ballcat.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.common.response.RetCode;
import com.ballcat.blog.dto.BlogCategoryDTO;
import com.ballcat.blog.entity.BlogCategory;
import com.ballcat.blog.mapper.BlogCategoryMapper;
import com.ballcat.blog.param.BlogCategoryParam;
import com.ballcat.blog.service.BlogCategoryService;
import com.ballcat.blog.vo.BlogCategoryVO;
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
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements BlogCategoryService {

    private final BlogCategoryMapper blogCategoryMapper;

    /**
     * 保存分类
     * @param blogCategoryDTO
     * @return
     */
    @Override
    public void saveBlogCategory(BlogCategoryDTO blogCategoryDTO) throws BizException {
        checkCategoryNameExists(blogCategoryDTO.getCategoryName());
        BlogCategory blogCategory = new BlogCategory();
        BeanUtil.copyProperties(blogCategoryDTO, blogCategory);
        save(blogCategory);
    }

    /**
     * 修改分类
     * @param blogCategoryDTO 要修改的分类信息
     */
    @Override
    public void updateBlogCategory(BlogCategoryDTO blogCategoryDTO) throws BizException {
        // 查询分类是否存在
        checkCategoryExists(blogCategoryDTO.getId());
        // 查询分类名称是否存在
        checkCategoryNameExists(blogCategoryDTO.getCategoryName());
        BlogCategory updateEntity = new BlogCategory();
        BeanUtil.copyProperties(blogCategoryDTO, updateEntity);
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
        BlogCategory category = blogCategoryMapper.getByCategoryName(categoryName);
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
    public CommonResult<List<BlogCategoryVO>> listBlogCategory(BlogCategoryParam param) {
        PageInfo<BlogCategory> pageInfo = PageHelper.startPage(param.getCurrentPage(), param.getPageSize()).doSelectPageInfo(() -> {
            blogCategoryMapper.listBlogCategory(param);
        });
        List<BlogCategory> list = pageInfo.getList();
        List<BlogCategoryVO> categoryVOList = list.stream().map(blogCategory -> {
            BlogCategoryVO blogCategoryVO = new BlogCategoryVO();
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
    public BlogCategoryVO getBlogCategoryById(Long id) throws BizException {
        BlogCategory blogCategory = checkCategoryExists(id);
        BlogCategoryVO blogCategoryVO = new BlogCategoryVO();
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
        blogCategoryMapper.enabledBlogCategory(id, enabled);
    }
}
