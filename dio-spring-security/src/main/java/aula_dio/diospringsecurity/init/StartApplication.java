package aula_dio.diospringsecurity.init;

import aula_dio.diospringsecurity.model.User;
import aula_dio.diospringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner { // Execução inicial "CommandLineRunner" paara carregar os usuarios da aplicação
    @Autowired
    private UserRepository repository; // Repositorio de requisições no banco de dados
    @Transactional
    @Override
    public void run(String... args) throws Exception { // checagem se existe o usuario, se não cria o usuario
        User user = repository.findByUsername("admin");
        if(user==null){
            user = new User();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword("master123");
            user.getRoles().add("MANAGERS");
            repository.save(user);
        }
        user = repository.findByUsername("user");
        if(user ==null){
            user = new User();
            user.setName("USER");
            user.setUsername("user");
            user.setPassword("user123");
            user.getRoles().add("USERS");
            repository.save(user);
        }
    }
}