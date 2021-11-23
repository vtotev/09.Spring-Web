package softuni.photostore.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import softuni.photostore.model.entity.enums.UserRoleEnum;

@Configuration
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;

  public AppSecurityConfiguration(
      UserDetailsService userDetailsService,
      PasswordEncoder passwordEncoder) {
    this.userDetailsService = userDetailsService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.
          authorizeRequests().
          requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
          antMatchers("/", "/users/login", "/users/register").permitAll().
          antMatchers("/statistics").hasRole(UserRoleEnum.ADMIN.name()).
          antMatchers("/**").authenticated().
        and().
          formLogin().
          loginPage("/users/login").
          usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
          passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
          defaultSuccessUrl("/").
          failureForwardUrl("/users/login-error").
        and().
          logout().
          logoutUrl("/users/logout").
          logoutSuccessUrl("/").
          invalidateHttpSession(true).
          deleteCookies("JSESSIONID");

  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // This gives spring two important components.
    // 1. Our user details service that translates usernames/emails, phone numbers, etc/
    //    to UserDetails
    // 2. Password encoder - the component that can decide if the user password matches
    auth.
        userDetailsService(userDetailsService).
        passwordEncoder(passwordEncoder);

    // registration:
    // topsecretpass -> password encoder -> kfskjhfkjshfkjdshfkjdsh (hashed pwd)

    // login:
    // (username, raw_password) ->
    // password_encoder.matches(raw_password, hashed_pwd)
  }
}
