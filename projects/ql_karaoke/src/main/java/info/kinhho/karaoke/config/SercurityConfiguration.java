package info.kinhho.karaoke.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SercurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private AccountPrincipalDetailsService accountPrincipalDetailsService;
	
	public SercurityConfiguration(AccountPrincipalDetailsService accountPrincipalDetailsService) {
		this.accountPrincipalDetailsService = accountPrincipalDetailsService;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		
		auth.authenticationProvider(authenticationProvider());			
	}
	
	protected void configure(HttpSecurity http) throws Exception {
        http
        	.csrf().disable()
            .authorizeRequests()           	
//            .anyRequest().authenticated()
            .anyRequest().anonymous()
            .and()
            .formLogin()
            	.loginProcessingUrl("/signin")
            	.loginPage("/login").permitAll()
            	.defaultSuccessUrl("/home")
            	.usernameParameter("username")
            	.passwordParameter("password")
            .and()
            .logout()
            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
    }
	
	@Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.accountPrincipalDetailsService);

        return daoAuthenticationProvider;
    }
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}