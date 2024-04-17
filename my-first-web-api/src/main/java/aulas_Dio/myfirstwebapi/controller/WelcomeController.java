package aulas_Dio.myfirstwebapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // componenete de caracteristicca rest
public class WelcomeController {
    @GetMapping //esse metodo se torna um recurso http do tipo get (com essa anotation)
    public String welcome(){
        return "Welcome to my Spring Boot Web API!";
        // algusn dos metodos da classe seram serviços e recursos http
    }
}
