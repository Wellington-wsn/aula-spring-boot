package aula_dio.diospringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Operações de propostas de negocio (requisições HTTP e objetos Json)
public class WelcomeController {
    @GetMapping // Rota direcionando para a pagina principal da aplicação (Welcome)
    public String welcome(){
        return "Welcome to My Spring Boot Web API";
    }
    // --- PERFIL USER ---
    @GetMapping("/users") // Rota de usuarios - imprime a autorização ao perfil, usuario
    // @PreAuthorize("hasAnyRole('MANAGERS','USERS')") Configuração de segurança remover os "perfies" de acesso
    public String users() {
        return "Authorized user";
    }
    // --- PERFIL MENAGER ---
    @GetMapping("/managers") // Rota de administradores
    // @PreAuthorize("hasRole('MANAGERS')") Configuração de segurança remover os "perfies "de acesso
    public String managers() {
        return "Authorized manager";
    }
}
