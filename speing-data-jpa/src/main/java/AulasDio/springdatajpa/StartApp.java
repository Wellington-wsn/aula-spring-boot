package AulasDio.springdatajpa;

import AulasDio.springdatajpa.model.User;
import AulasDio.springdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // (Objeto gerenciavel)
public class StartApp implements CommandLineRunner {
    @Autowired // Para conexão automadica com o banco de dados (injeção de dependencias)
    private UserRepository repository; // Injetando o repository do user para usar os recursos de implementação com o banco de dados
    @Override // (Sobrepor) metodo main
    public void run(String... args) throws Exception { // Metodo parecido com o metodo main (metodo principal da inicialização de um codigo)
        // Criando o usuario
        User user = new User();
        user.setName("Wellington");
        user.setUsername("WSN");
        user.setPassword("dioaula");

        repository.save(user); // metodo CRUD pronto do framework

        // confirma se o usuario foi salvo
        for(User u: repository.findAll()){
            System.out.println(u);
        }

    }
}
