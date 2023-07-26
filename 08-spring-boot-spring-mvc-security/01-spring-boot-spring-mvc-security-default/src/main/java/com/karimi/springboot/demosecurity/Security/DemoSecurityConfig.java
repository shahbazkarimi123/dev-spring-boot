package com.karimi.springboot.demosecurity.Security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
        //add support for jdbc .. no more hardcoded users
        @Bean
        public UserDetailsManager userDetailsManager(DataSource DataSource){
                // return new JdbcUserDetailsManager(DataSource); if data base has username and password define as it is
                JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(DataSource);
                // define query to retrieve a user by username
                jdbcUserDetailsManager.setUsersByUsernameQuery(
                        "Select user_id,pw, active from members where user_id=?");
                //define query retrieve the authorities/roles by username
                jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                        "Select user_id, role from roles where user_id=?");

                return jdbcUserDetailsManager;
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

        /*
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

        */
}
