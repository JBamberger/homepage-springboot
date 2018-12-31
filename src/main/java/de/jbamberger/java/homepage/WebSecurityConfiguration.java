package de.jbamberger.java.homepage;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withDefaultPasswordEncoder()
                        .username("jannik")
                        .password("helloworld")
                        .authorities("ROLE_ADMIN", "ROLE_USER")
                        .build()
        );
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(EndpointRequest.to("info")).permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")
                .antMatchers("/h2-console").hasRole("ADMIN")
                .mvcMatchers("/", "/privacy_policy").permitAll()
                .antMatchers("/css/**", "/js/**", "/img/**", "/error/**").permitAll();
        http.httpBasic();
        http.headers().frameOptions().sameOrigin();
    }
}
