package svt.st.managementresot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import svt.st.managementresot.utils.EncodePassword;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    // Configure SecurityFilterChain
    @Bean
     public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                 .requestMatchers("/register/**").permitAll()
                .requestMatchers("/").permitAll()
                .requestMatchers("/services/**").permitAll()
                .requestMatchers("/css/StyleHome.css").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/js/**").permitAll()
                .requestMatchers("/images/**").permitAll()
                .requestMatchers("/fontawesome/**").permitAll()
                .requestMatchers("/webfonts/**").permitAll()
                .requestMatchers("/home").permitAll()
                .requestMatchers("/cart/**").permitAll()
                .requestMatchers("/add-info-employee/**").permitAll()
                .requestMatchers("/employee/**").hasAuthority("ADMIN")
                .requestMatchers("/creation_service/**").hasAuthority("ADMIN")
                .requestMatchers("/users/**").hasAuthority("ADMIN")
                .requestMatchers("/account").authenticated()
                .requestMatchers("/creation/**").permitAll()
                .and()
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/services")
//                                .failureUrl("/login?error=true")
                                .permitAll()
                )
                .logout(
                        logout -> logout
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/login?logout")
                                .permitAll()
                )
        ;
        return httpSecurity.build();
     }


     @Autowired
     public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(EncodePassword.passwordEncoder());
     }

//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.addDialect(new SpringSecurityDialect());
//        // Add other dialects and configurations as needed
//        return templateEngine;
//    }

}
