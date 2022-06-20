package com.codesquad.issuetracker.common.config;

import com.codesquad.issuetracker.auth.application.AuthService;
import com.codesquad.issuetracker.auth.application.JwtProvider;
import com.codesquad.issuetracker.auth.presentation.interceptor.LoginInterceptor;
import com.codesquad.issuetracker.auth.presentation.argumentresolver.AuthArgumentResolver;
import com.codesquad.issuetracker.auth.presentation.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class AuthConfig implements WebMvcConfigurer {

    private final JwtProvider jwtProvider;
    private final AuthService authService;

    public AuthConfig(JwtProvider jwtProvider, AuthService authService) {
        this.jwtProvider = jwtProvider;
        this.authService = authService;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new AuthArgumentResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/**")
                .order(1)
                .excludePathPatterns(
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/oauth/login",
                        "/login",
                        "/join/**",
                        "/error/**");

        registry.addInterceptor(loginInterceptor())
                .order(2)
                .addPathPatterns("/oauth/login");
    }

    private AuthInterceptor authInterceptor() {
        return new AuthInterceptor(authService);
    }

    private LoginInterceptor loginInterceptor() {
        return new LoginInterceptor(jwtProvider);
    }


}
