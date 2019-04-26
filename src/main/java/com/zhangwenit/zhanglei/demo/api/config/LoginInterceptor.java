package com.zhangwenit.zhanglei.demo.api.config;

import com.zhangwenit.zhanglei.demo.api.model.User;
import com.zhangwenit.zhanglei.demo.api.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangwen
 */
@Configuration
public class LoginInterceptor implements HandlerInterceptor {

    private final RedisService redisService;

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private static final String REQUEST_OPTIONS = "OPTIONS";

    public LoginInterceptor(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (REQUEST_OPTIONS.equals(request.getMethod())) {
            return true;
        }
        String token = request.getHeader("token");
        if (token == null || "".equals(token)) {
            logger.info("token is null");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        User user = redisService.findByToken(token);
        if (user == null) {
            logger.info("token is expired : {}", token);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        //将token重新做过期时间处理
        redisService.reExpireToken(token);
        request.setAttribute("user", user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
