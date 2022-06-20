package com.codesquad.issuetracker.auth.presentation.argumentresolver;

import com.codesquad.issuetracker.auth.application.AuthService;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthArgumentResolver implements HandlerMethodArgumentResolver {

    private final AuthService authService;

    public AuthArgumentResolver(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        boolean hasAuth = parameter.hasParameterAnnotation(Auth.class);
        boolean hasUser = com.codesquad.issuetracker.user.domain.User.class.isAssignableFrom(parameter.getParameterType());

        return hasAuth && hasUser;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String token = (String) request.getAttribute("Authorization");
        return authService.findUser(token);

    }
}
