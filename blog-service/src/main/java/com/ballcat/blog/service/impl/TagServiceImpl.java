package com.ballcat.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.common.response.RetCode;
import com.ballcat.blog.dto.TagDTO;
import com.ballcat.blog.entity.Category;
import com.ballcat.blog.entity.Tag;
import com.ballcat.blog.mapper.TagMapper;
import com.ballcat.blog.param.TagParam;
import com.ballcat.blog.service.TagService;
import com.ballcat.blog.vo.TagVO;
import com.ballcat.blog.vo.TagVO;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    private final TagMapper tagMapper;

    /**
     * 保存标签
     * @param tagDTO
     * @return
     */
    @Override
    public void saveBlogTag(TagDTO tagDTO) throws BizException {
        checkTagNameExists(tagDTO.getTagName());
        Tag tag = new Tag();
        BeanUtil.copyProperties(tagDTO, tag);
        save(tag);
    }

    /**
     * 修改标签
     * @param tagDTO 要修改的标签信息
     */
    @Override
    public void updateBlogTag(TagDTO tagDTO) throws BizException {
        // 查询标签是否存在
        checkTagExists(tagDTO.getId());
        // 查询标签名称是否存在
        checkTagNameExists(tagDTO.getTagName());
        Tag updateEntity = new Tag();
        BeanUtil.copyProperties(tagDTO, updateEntity);
        updateById(updateEntity);
    }

    /**
     * 根据ID查询标签是否存在
     * @param id 标签ID
     */
    private Tag checkTagExists(Long id) throws BizException {
        Tag tag = getById(id);
        if (ObjectUtil.isNull(tag)) {
            throw new BizException(RetCode.NOT_FOUND);
        }
        return tag;
    }

    /**
     * 校验标签名称是否存在
     * @param tagName 标签名称
     */
    private void checkTagNameExists(String tagName) throws BizException {
        Tag tag = tagMapper.getByTagName(tagName);
        if (ObjectUtil.isNotNull(tag)) {
            throw new BizException("该标签已经存在");
        }
    }

    /**
     * 分页查询
     * @param param 查询入参
     * @return 博客标签列表
     */
    @Override
    public CommonResult<List<TagVO>> listBlogTag(TagParam param) {
        PageInfo<Tag> pageInfo = PageHelper.startPage(param.getCurrentPage(), param.getPageSize()).doSelectPageInfo(() -> {
            tagMapper.listBlogTag(param);
        });
        List<Tag> list = pageInfo.getList();
        List<TagVO> tagVOList = list.stream().map(tag -> {
            TagVO blogTagVO = new TagVO();
            BeanUtil.copyProperties(tag, blogTagVO);
            return blogTagVO;
        }).collect(Collectors.toList());
        return CommonResult.ok(tagVOList, pageInfo.getTotal());
    }

    /**
     * 根据ID查询标签详情
     * @param id 标签ID
     * @return 标签详情
     */
    @Override
    public TagVO getBlogTagById(Long id) throws BizException {
        Tag tag = checkTagExists(id);
        TagVO blogTagVO = new TagVO();
        BeanUtil.copyProperties(tag, blogTagVO);
        return blogTagVO;
    }

    /**
     * 启用禁用标签
     * @param id 标签ID
     * @param enabled 启用状态
     */
    @Override
    public void enabled(Long id, Boolean enabled) throws BizException {
        checkTagExists(id);
        tagMapper.enabledBlogTag(id, enabled);
    }

    /**
     * 删除标签
     * @param id
     */
    @Override
    public void removeTagById(Long id) throws BizException {
        checkTagExists(id);
        tagMapper.deleteById(id);
    }

    /**
     * 所有分类
     * @return
     */
    @Override
    public List<TagVO> allTag() {
        List<Tag> allTag = tagMapper.allTag();
        List<TagVO> tagVOList = allTag.stream().map(tag -> {
            TagVO tagVO = new TagVO();
            BeanUtil.copyProperties(tag, tagVO);
            return tagVO;
        }).collect(Collectors.toList());
        return tagVOList;
    }
}
