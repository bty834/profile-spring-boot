package com.bty.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.security.PermitAll;

/**
 * @author bty
 * @date 2022/11/28
 * @since 1.8
 **/
@Configuration
public class WebConfig  implements WebMvcConfigurer {

    /**
     * 跨域配置
     */
    @Bean
    public CorsFilter corsFilter()
    {
        CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
        config.setAllowCredentials(true);
        // 设置访问源地址

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        // 返回新的CorsFilter
        return new CorsFilter(source);
    }
}
