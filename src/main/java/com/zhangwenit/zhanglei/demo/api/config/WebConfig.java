package com.zhangwenit.zhanglei.demo.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @ClassName WebConfig
 * @Description web interceptor
 * @Author XuQiuliang
 * @Date 2018/11/5 4:20 PM
 * @Version 1.0
 **/
@Configuration
@EnableWebMvc
@Order(1)
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    @Lazy
    private LoginInterceptor loginInterceptor;
    @Autowired
    @Lazy
    private MiniLoginInterceptor miniLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/api/**")
                //不拦截登录相关接口(需要拦截退出登录和第一次登录修改密码)
                .excludePathPatterns("/api/login/**")
                .excludePathPatterns("/api/register/**")
                .excludePathPatterns();
        registry.addInterceptor(miniLoginInterceptor).addPathPatterns("/api-mini/**").excludePathPatterns();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*")
                //允许前端拿到的headers
                .exposedHeaders("Authorization", "Access-Control-Allow-Origin")
                //跨域允许时间
                .maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
