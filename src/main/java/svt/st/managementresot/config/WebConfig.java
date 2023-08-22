package svt.st.managementresot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import svt.st.managementresot.interceptors.AccountInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AccountInterceptor accountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accountInterceptor).addPathPatterns("/account");
    }
}
