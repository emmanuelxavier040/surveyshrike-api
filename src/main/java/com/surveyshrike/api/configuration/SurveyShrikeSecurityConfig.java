package com.surveyshrike.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.google.common.base.Predicates;
import com.surveyshrike.api.security.AuthenticationFilter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebSecurity
@EnableSwagger2
public class SurveyShrikeSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public Docket surveyShrikeAPI() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error.*"))).build();
	}

	@Bean
	public AuthenticationFilter apiAuthenticationFilter() {
		return new AuthenticationFilter();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().cacheControl();
		http.csrf().disable();

		http.headers().frameOptions().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.cors().and().authorizeRequests().anyRequest().authenticated();
		http.cors();
		http.addFilterBefore(apiAuthenticationFilter(), BasicAuthenticationFilter.class);
//		http.httpBasic();
	}

}
