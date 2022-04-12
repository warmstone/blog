package com.ballcat.blog.service;

import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.CommonResult;
import com.ballcat.blog.dto.BlogDTO;
import com.ballcat.blog.entity.Blog;
import com.ballcat.blog.param.BlogParam;
import com.ballcat.blog.vo.BlogVO;
import com.ballcat.blog.vo.detail.BlogDetailVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-11 22:20
 * @description
 */
public interface BlogService extends IService<Blog> {

    /**
     * 博客列表
     * @param param 查询入参
     * @return 博客列表
     */
    CommonResult<List<BlogVO>> listBlog(BlogParam param);

    /**
     * 查询博客详情
     * @param id
     * @return
     */
    BlogDetailVO getBlogById(Long id) throws BizException;

    /**
     * 新增博客
     * @param blogDTO
     * @throws Exception
     */
    void saveBlog(BlogDTO blogDTO) throws Exception;

    /**
     * 修改博客
     * @param blogDTO
     * @throws Exception
     */
    void updateBlog(BlogDTO blogDTO) throws Exception;

    /**
     * 阅读排行
     * @return
     */
    List<BlogVO> rankList();

    /**
     * 查询博客总数
     * @return
     */
    int countBlog();
}
