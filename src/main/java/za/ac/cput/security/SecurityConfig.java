package za.ac.cput.security;

/**
 * SecurityConfig.java
 * To configure the security privileges for the different endpoints
 * Author: Jason Jaftha (217009301)
 * Date: 4 October 2021
 **/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Note the username and password below:
     * username: Admin
     * password: admin123
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("Admin")
        .password(encoder().encode("admin123"))
        .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()

        .and()
        .authorizeRequests()

        //Dog endpoints
            .antMatchers(HttpMethod.POST, "**/create").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "**/read").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "**/update").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "**/delete").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "**/getAll").hasRole("ADMIN")
        //DogDescription endpoints

        //Customer endpoints

        //AdoptionRecord endpoints

        //Staff endpoints

        //Veterinarian endpoints

        //Disable
            .and()
            .csrf().disable()
            .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder()
    {
        return new BCryptPasswordEncoder();
    }
}