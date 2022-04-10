package com.ballcat.blog.interceptor;

import cn.hutool.core.util.ObjectUtil;
import com.ballcat.blog.common.exception.BizException;
import com.ballcat.blog.common.response.RetCode;
import com.ballcat.blog.common.util.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author pengshun
 * @date 2022-04-10 23:02
 * @description 登陆拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 验证用户是否登陆
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if (ObjectUtil.isNull(authorization)) {
            throw new BizException(RetCode.UNAUTHORIZED);
        }
        try {
            String username = JWTUtil.getUsernameFromToken(authorization);
        } catch (Exception e) {
            logger.info("==================token解析异常==================");
            throw new BizException(RetCode.UNAUTHORIZED);
        }
        return true;
    }
}
