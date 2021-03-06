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
            .antMatchers(HttpMethod.POST, "dog/create").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "dog/read").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "dog/update").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "dog/delete").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "dog/getAll").hasRole("ADMIN")
        //Staff endpoints
            .antMatchers(HttpMethod.POST, "staff/create").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "staff/read").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "staff/update").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "staff/delete").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "staff/getAll").hasRole("ADMIN")
        //Customer endpoints
            .antMatchers(HttpMethod.POST, "customer/create").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "customer/read").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "customer/update").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "customer/delete").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "customer/getAll").hasRole("ADMIN")
        //AdoptionRecord endpoints
            .antMatchers(HttpMethod.POST, "adoptionRecord/create").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "adoptionRecord/read").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "adoptionRecord/update").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "adoptionRecord/delete").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "adoptionRecord/getAll").hasRole("ADMIN")
        //DogDescription endpoints

        //Veterinarian endpoints
                .antMatchers(HttpMethod.POST, "veterinarian/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "veterinarian/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "veterinarian/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "veterinarian/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "veterinarian/getAll").hasRole("ADMIN")
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
