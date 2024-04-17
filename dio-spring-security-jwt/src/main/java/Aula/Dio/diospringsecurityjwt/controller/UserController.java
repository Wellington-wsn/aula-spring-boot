package Aula.Dio.diospringsecurityjwt.controller;

import Aula.Dio.diospringsecurityjwt.model.User;
import Aula.Dio.diospringsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")  // mapeamanto do recurso em 'users'
public class UserController {
    @Autowired
    private UserService service; // Cadastro simples

    @PostMapping
    public void postUser(@RequestBody User user) { // requisição de um serviço, via POST
        service.createUser(user); // cadastro de usuario
    }
}
