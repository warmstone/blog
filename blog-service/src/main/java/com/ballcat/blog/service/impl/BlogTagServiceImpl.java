package com.ballcat.blog.service.impl;

import com.ballcat.blog.entity.BlogTag;
import com.ballcat.blog.mapper.BlogTagMapper;
import com.ballcat.blog.service.BlogTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author pengshun
 * @date 2022-04-12 10:19
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag> implements BlogTagService {
}
