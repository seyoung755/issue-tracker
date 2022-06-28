package com.codesquad.issuetracker.common.config;

import com.codesquad.issuetracker.auth.presentation.argumentresolver.AuthArgumentResolver;
import com.codesquad.issuetracker.auth.presentation.interceptor.AuthInterceptor;
import com.codesquad.issuetracker.user.application.oauth.OAuthProvider;
import com.codesquad.issuetracker.user.domain.LoginType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Configuration
public class AuthConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;
    private final AuthArgumentResolver authArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(authArgumentResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/auth/**",
                        "/oauth/**",
                        "/login",
                        "/join/**",
                        "/error/**",
                        "/favicon.ico");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

    @Bean
    public EnumMap<LoginType, OAuthProvider> oAuthProviderEnumMap(List<OAuthProvider> oAuthProviders) {
        return new EnumMap<>(oAuthProviders.stream()
                .collect(Collectors.toMap(OAuthProvider::getOAuthType, u -> u)));
    }
}
