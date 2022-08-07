package com.chen.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author whc
 * @date 2022/8/7 11:43
 */
//@Order(-1)
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 网关基于 WebFlux 响应式编程编写，api可能有些不一样

        // 1. 获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        // 2. 获取参数中的authorization 参数
        MultiValueMap<String, String> params = request.getQueryParams();
        // 3， 判断参数值是否等于 admin
        String auth = params.getFirst("authorization");
        // 4. 如果相等，放行
        if ("admin".equals(auth)) {
            return chain.filter(exchange);
        }

        // 设置响应码，未登录
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

        // 5，如果不等，则拦截
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
