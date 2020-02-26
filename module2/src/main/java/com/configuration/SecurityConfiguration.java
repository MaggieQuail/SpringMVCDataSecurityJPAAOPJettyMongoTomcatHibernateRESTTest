package com.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.services.UserDetailsSecurityService;

//Securiry test
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsSecurityService userDetailsService;

    private UserDetailsSecurityService getUserDetailsService() {
        return userDetailsService;
    }

    @Autowired
    public void setUserDetailsService(@Lazy UserDetailsSecurityService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/protected/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/confidential/**").access("hasRole('ROLE_SUPERADMIN')")
                .antMatchers("/error").permitAll()
                .antMatchers("/dbSecurity/**").access("hasRole('ROLE_DBADMIN')")
                .and().formLogin().defaultSuccessUrl("/", false);
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {
        builder.inMemoryAuthentication().withUser("azaza").password("{noop}111").roles("USER");
        builder.inMemoryAuthentication().withUser("1").password("{noop}1").roles("ADMIN");
        builder.inMemoryAuthentication().withUser("ClintEastwood").password("{noop}1").roles("SUPERADMIN");
        builder.userDetailsService(getUserDetailsService());
    }

}
