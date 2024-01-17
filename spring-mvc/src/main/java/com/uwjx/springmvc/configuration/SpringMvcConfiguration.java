package com.uwjx.springmvc.configuration;

import com.uwjx.springmvc.converter.MyConverter;
import com.uwjx.springmvc.converter.StringToBRequestConverter;
import com.uwjx.springmvc.resolver.PersonArgumentResolver;
import com.uwjx.springmvc.vo.BRequestVO;
import com.uwjx.springmvc.vo.ProductRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@Slf4j
public class SpringMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    PersonArgumentResolver personArgumentResolver;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        log.warn("添加 WebMvcConfigurer addFormatters");
        registry.addConverter(ProductRequestVO.class , BRequestVO.class , new MyConverter());
        registry.addConverter(new StringToBRequestConverter());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        log.warn("添加 WebMvcConfigurer addArgumentResolvers");
        resolvers.add(personArgumentResolver);
    }
}
