package Aula.Dio.diospringsecurityjwt.controller;

import Aula.Dio.diospringsecurityjwt.dtos.Login;
import Aula.Dio.diospringsecurityjwt.dtos.Sessao;
import Aula.Dio.diospringsecurityjwt.model.User;
import Aula.Dio.diospringsecurityjwt.repository.UserRepository;
import Aula.Dio.diospringsecurityjwt.security.JWTCreator;
import Aula.Dio.diospringsecurityjwt.security.JWTObject;
import Aula.Dio.diospringsecurityjwt.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public Sessao logar(@RequestBody Login login){ //recebido por request body, retorna um objeto sessão
        User user = repository.findByUsername(login.getUsername());
        if(user!=null) {
            boolean passwordOk =  encoder.matches(login.getPassword(), user.getPassword()); // pega senha enviada (login.getPasswor) e o encoder verifica com a do banco de dados (user.getPassword)
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }
            //Estamos enviando um objeto Sessão para retornar mais informações do usuário
            Sessao sessao = new Sessao();
            sessao.setLogin(user.getUsername()); // Se a senha retornar ok(200) ele monta um objeto sessao

            JWTObject jwtObject = new JWTObject(); // O objeto sessão vai ter JWTObject
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject)); // Gerando token  com o objeto localizado
            return sessao; // Resposta de uma sessão com o token
        }else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
