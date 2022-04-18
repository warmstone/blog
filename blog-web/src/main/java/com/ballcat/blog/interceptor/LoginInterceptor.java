package com.ballcat.blog.interceptor;

import cn.hutool.core.date.DateUtil;
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
        String token = request.getHeader("Authorization");
        try {
            Boolean expired = JWTUtil.isTokenExpired(token);
            if (expired) {
                // 登录失效
                throw new BizException(RetCode.LOGIN_EXPIRED);
            }
            // 可以获取到用户信息并放入ThreadLocal以便在业务处理时获取
            String username = JWTUtil.getUsernameFromToken(token);
            Boolean canTokenBeRefreshed = JWTUtil.canTokenBeRefreshed(token, DateUtil.date());
            logger.info("canTokenBeRefreshed: {}", canTokenBeRefreshed);
            if (canTokenBeRefreshed) {
                String refreshToken = JWTUtil.refreshToken(token);
                response.setHeader("token", refreshToken);
            }
        } catch (Exception e) {
            logger.info("==================token解析异常==================");
            throw new BizException(RetCode.UNAUTHORIZED);
        }
        return true;
    }
}
