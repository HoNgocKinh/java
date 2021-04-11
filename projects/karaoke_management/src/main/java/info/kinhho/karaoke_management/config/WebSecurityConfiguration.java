package info.kinhho.karaoke_management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private UserDetailsService userDetailsService;
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()
				.antMatchers("/js/**", "/css/**", "/images/**").permitAll()
				// admin for /rooms, /roomprice, /suppliers, /warehouse, /statistic
				.antMatchers("/rooms", "/roomprice", "/suppliers", "/warehouse").access("hasRole('ADMIN')")
				.antMatchers("/statistic").access("hasRole('ADMIN') or hasRole('ACCOUNTING')")
				.antMatchers("/login", "/logout").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()//
		        // Submit URL của trang login
		        .loginProcessingUrl("/loginPost") // Submit URL
		        .loginPage("/login")//
		        .defaultSuccessUrl("/")//
		        .failureUrl("/login?error=true")//
		        .usernameParameter("username")//
		        .passwordParameter("password")
	        // Cấu hình cho Logout Page.
	        .and()
		        .logout()
		        .logoutUrl("/logout")
		        .logoutSuccessUrl("/login");
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}
