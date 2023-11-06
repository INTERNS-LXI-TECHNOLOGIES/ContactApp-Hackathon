package com.lxisoft.contactapp.contactapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import com.lxisoft.contactapp.contactapplication.service.UserInfoUserDetailService;;

// import com.intellipals.serverside.myfeedserver.service.UserInfoUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


	@Bean
	public UserDetailsService userDetailsService(){
    System.out.println("userdetails beans");
		return new UserInfoUserDetailService();
	}

	@Bean
    public PasswordEncoder passwordEncoder() {
      
        return new BCryptPasswordEncoder();
    }

    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

  http.cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
    .authorizeHttpRequests((authorize) -> 
      authorize
      .requestMatchers("/users/ok").authenticated()
        .requestMatchers("/users/adduser","/users/signup", "/images/**","/api-docs.yaml","/swagger-ui-custom.html").permitAll()
          .anyRequest()
          .authenticated()).
          httpBasic(withDefaults()).
     formLogin(withDefaults());
    // ... form login config
            // .ignoringRequestMatchers("/users/adduser", "/images/**", "/createuser","/users/signup","/api-docs","/users/welcome","/api-docs.yaml","/swagger-ui-custom.html","users/loginPage.html") 
  return http.build();
}
    @Bean
    public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(); 
    authenticationProvider.setUserDetailsService(userDetailsService());
     authenticationProvider.setPasswordEncoder(passwordEncoder());
     return authenticationProvider;

}

	
}

