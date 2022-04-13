package com.ballcat.blog.service.impl;

import com.ballcat.blog.service.BlogService;
import com.ballcat.blog.service.StatisticalDataService;
import com.ballcat.blog.vo.StatisticalDataVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author pengshun
 * @date 2022-04-12 18:15
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class StatisticalDataServiceImpl implements StatisticalDataService {

    private final BlogService blogService;

    @Override
    public StatisticalDataVO getStatisticData() {
        // 查询博客总数
        int totalBlogNum = blogService.countBlog();
        // 查询上周发布博客数
        
        return null;
    }
}
