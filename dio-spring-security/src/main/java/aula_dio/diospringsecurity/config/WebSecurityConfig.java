package aula_dio.diospringsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration // Classe de configuração
@EnableWebSecurity // abilitando segurança web
@EnableGlobalMethodSecurity(prePostEnabled = true) // ativando recursos globa de validaçõa nas requisições
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired // implementando serviço de segurança com o banco de dados
    private SecurityDatabaseService securityService;
    @Autowired // Ingetar uma autenticação de um gerenciador,
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    } // 'NoOpPasswordEncoder' - banco de dados sem criptografia

    @Override // Sobrepor metodos de configuração (rotas de acesso)
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()  // Permitir executar na rota padrão(raiz), qualquer pessoal pode acessar
                .antMatchers(HttpMethod.POST,"/login").permitAll() // Permitir executar na rota de login e requisições do tipo 'POST'
                .antMatchers("/managers").hasAnyRole("MANAGERS") // acesso restrito a perfil 'Menager'
                .antMatchers("/users").hasAnyRole("USERS","MANAGERS") // acesso restrito a usuario logado
                .anyRequest().authenticated().and().httpBasic(); // autenticação basica, por recurso de http
                // .anyRequest().authenticated().and().formLogin(); autenticação via tela de login
    }

    /*  Dados usando banco de dados, não mais em memoria.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // Criando uma cadeia de usuarios em memória
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}user123")  // estrategia de criptografia {noop}
                .roles("USERS")             // Perfil de acesso 'USUARIO'
                .and()
                .withUser("admin")
                .password("{noop}master123")
                .roles("MANAGERS");         // Perfil de acesso 'Gerenciador'
    }
     */
}