package com.codesquad.issuetracker.auth.presentation.argumentresolver;

import com.codesquad.issuetracker.auth.application.AuthService;
import com.codesquad.issuetracker.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class AuthArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        boolean hasAuth = parameter.hasParameterAnnotation(Auth.class);
        boolean hasUserId = Long.class.isAssignableFrom(parameter.getParameterType());

        return hasAuth && hasUserId;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        long userId =(long) request.getAttribute("userId");

        return userId;
    }
}
