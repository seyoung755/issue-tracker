package com.codesquad.issuetracker.auth.presentation.argumentresolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class AuthArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {

//        해당 파라미터에 Auth 어노테이션이 붙어 있는가?
        boolean hasAuth = parameter.hasParameterAnnotation(Auth.class);

//        해당 파라미터의 타입이 User 타입인가?
        boolean hasUser = com.codesquad.issuetracker.user.domain.User.class.isAssignableFrom(parameter.getParameterType());

        return hasAuth && hasUser;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        //httpServletRequest를 사용하기 위한 작업
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        return request.getAttribute("user");
    }
}
