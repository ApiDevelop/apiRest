package com.example.apiRest.security;

import com.example.apiRest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AutenticationService autenticationService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    //configuracoes de autenticacao
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //configuracoes de autorizacao
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/h2-console/**").permitAll()
        .antMatchers(HttpMethod.GET, "/api/v1/films").permitAll()
        .antMatchers(HttpMethod.GET, "/api/v1/films/*").permitAll()
        .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
        .antMatchers(HttpMethod.POST, "/auth").permitAll()
        .antMatchers(HttpMethod.POST, "/api/v1/films").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/api/v1/films/*").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/api/v1/films").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and().csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().headers().frameOptions().sameOrigin()
        .and().addFilterBefore(new AuthenticationViaTokenFilter(tokenService, userRepository), UsernamePasswordAuthenticationFilter.class);
    }

    //configuracoes de recusross estaticos (js, css, imagens, etc...)
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
    }

}
