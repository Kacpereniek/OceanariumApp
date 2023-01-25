package bdbt_project.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }
    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()

                .antMatchers("/main").authenticated()
                .antMatchers("/pracownicy").authenticated()
                .antMatchers("/okazy").authenticated()
                .antMatchers("/bilety").authenticated()
                .antMatchers("/newgatunek_admin").authenticated()

                .antMatchers("/newokaz_admin/{id_gatunku}").authenticated()
                .antMatchers("/editokaz/{id_okazu}").authenticated()
                .antMatchers("/editgatunek/{id_gatunku}").authenticated()
                .antMatchers("/editpracownik/9").authenticated()
                .antMatchers("/editadres/4").authenticated()

                .antMatchers("/main_admin").access("hasRole('ADMIN')")
                .antMatchers("/newbilet_admin").access("hasRole('ADMIN')")
                .antMatchers("/pracownicy_admin").access("hasRole('ADMIN')")
                .antMatchers("/newpracownik_admin/{id_adresu}").access("hasRole('ADMIN')")
                .antMatchers("/editadres/{id_adresu}").access("hasRole('ADMIN')")
                .antMatchers("/editbilet/{id_bilet}").access("hasRole('ADMIN')")
                .antMatchers("/editpracownik/{id_pracownika}").access("hasRole('ADMIN')")
                .antMatchers("/newadres_admin").access("hasRole('ADMIN')")
                .antMatchers("/okazy_admin").access("hasRole('ADMIN')")
                .antMatchers("/bilety_admin").access("hasRole('ADMIN')")

                .antMatchers("/main_user").access("hasRole('USER')")
                .antMatchers("/newbilet_user").access("hasRole('USER')")
                .antMatchers("/pracownicy_user").access("hasRole('USER')")
                .antMatchers("/okazy_user").access("hasRole('USER')")
                .antMatchers("/bilety_user").access("hasRole('USER')")

                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/index")
                .logoutSuccessUrl("/index")
                .permitAll();
    }
}