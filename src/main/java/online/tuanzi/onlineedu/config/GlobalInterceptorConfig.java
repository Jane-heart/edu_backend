package online.tuanzi.onlineedu.config;


import online.tuanzi.onlineedu.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class GlobalInterceptorConfig implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册UserLoginInterceptor拦截器
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(               //添加不拦截路径
                        "/swagger-ui/**",
                        "/swagger-resources/**",
                        "/v3/api-docs",
                        "/webjars/**",
                        "/**/*.html",   //html静态资源
                        "/**/*.js",     //js静态资源
                        "/**/*.css",     //css静态资源
                        "/error"        //取消拦截BasicErrorController自带的异常处理
                );
    }
}