package hello.login;

import hello.login.web.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LogFilter()); // 등록할 필터를 지정
        filterFilterRegistrationBean.setOrder(1); // 필터는 체인으로 동작, 값이 낮을 수록 먼저 동작한다.
        filterFilterRegistrationBean.addUrlPatterns("/*"); // 필터를 적용할 URL 패턴

        return filterFilterRegistrationBean;
    }
}
