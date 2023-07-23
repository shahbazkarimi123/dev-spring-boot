package com.karimi.springboot.demosecurity.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
        @Bean
        public InMemoryUserDetailsManager userDetailsManager() {
                UserDetails john = User.builder()
                                .username("john")
                                .password("{noop}test123")
                                .roles("EMPLOYEE").build();

                UserDetails marry = User.builder().username("marry").password("{noop}test123")
                                .roles("EMPLOYEE", "MANAGER").build();

                UserDetails susan = User.builder().username("susan")
                                .password("{noop}susan")
                                .roles("EMPLOYEE", "MANAGER", "ADMIN").build();

                return new InMemoryUserDetailsManager(john, marry, susan);
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests(configurer -> configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leaders/**").hasRole("MANAGER")
                                .requestMatchers("systems/**").hasRole("ADMIN")
                                .anyRequest().authenticated())
                                .formLogin(form -> form.loginPage("/showMyLoginPage")
                                                .loginProcessingUrl("/authenticateTheUser")
                                                .permitAll())
                                .logout(logout -> logout.permitAll())
                                .exceptionHandling(configurer ->
                                // request mapping path "/access-denied"
                                configurer.accessDeniedPage("/access-denied"))
                                ;

                return http.build();
        }
}
