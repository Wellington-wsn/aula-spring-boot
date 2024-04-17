package Aula.Dio.diospringsecurityjwt.service;


import Aula.Dio.diospringsecurityjwt.model.User;
import Aula.Dio.diospringsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService { // Service responsavel por criptografar o usuario
    @Autowired
    private UserRepository repository; // Salvar usuario
    @Autowired
    private PasswordEncoder encoder; // abilitar criptografia
    public void createUser(User user){
        String pass = user.getPassword(); // pegar senha passada
        //criptografando antes de salvar no banco
        user.setPassword(encoder.encode(pass)); // criptografando senha
        repository.save(user); // salvar usuario com a senha
    }
}
