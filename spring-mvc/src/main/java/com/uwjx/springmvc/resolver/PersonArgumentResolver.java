package com.uwjx.springmvc.resolver;

import com.alibaba.fastjson.JSON;
import com.uwjx.springmvc.model.Person;
import com.uwjx.springmvc.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class PersonArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Map<Object , Object> map = new HashMap<>();

    static {
        map.put(Person.class , User.class);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.warn("{} -{}" , getClass().getSimpleName() , "supportsParameter");
        log.warn("getParameterType -> {}" , parameter.getParameterType() );
        if(map.containsKey(parameter.getParameterType())){
            log.warn("在包含范围内");
            return true;
        }
        log.warn("不在包含范围内");
//        return parameter.getParameterType().equals(Person.class);
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        log.warn("{} -{}" , getClass().getSimpleName() , "resolveArgument");
        log.warn("MethodParameter -> {}" , JSON.toJSONString(webRequest.getParameterMap()) );
        String paramStr = webRequest.getParameter("person");
        log.warn("paramStr :  {}" , paramStr);
        User user = new User();
        user.setId(222L);
        user.setName("王欢");
        return user;
    }
}
