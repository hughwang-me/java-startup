package com.uwjx.springmvc.resolver;

import com.alibaba.fastjson.JSON;
import com.uwjx.springmvc.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@Slf4j
public class PersonArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.warn("{} -{}" , getClass().getSimpleName() , "supportsParameter");
        log.warn("MethodParameter -> {}" , parameter.getParameterType() );

        return parameter.getParameterType().equals(Person.class);
//        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        log.warn("{} -{}" , getClass().getSimpleName() , "resolveArgument");
        log.warn("MethodParameter -> {}" , JSON.toJSONString(webRequest.getParameterMap()) );
        String paramStr = webRequest.getParameter("person");
        log.warn("paramStr :  {}" , paramStr);
        return null;
    }
}
