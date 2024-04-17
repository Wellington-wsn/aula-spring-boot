package aulas_Dio.myfirstwebapi.controller;

import aulas_Dio.myfirstwebapi.model.Usuario;
import aulas_Dio.myfirstwebapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Direciona a funcionalidade da aplicação (não aplicar regras de negocio na camada controlles)
@RequestMapping("/users") // centraliza o prefixo das URI nas requisições para '/users'
public class UsuarioContoller { //recurso de mapeamento para acesso de reoplicas do sistema
    @Autowired // conexão com a classe de serviço
    private UsuarioRepository repository; // Implementação do CRUD (regra de negocio)

    //@GetMapping("/users")  rota da requisição já endereçado em '@RequestMapping'
    @GetMapping() // No Sistema contem dois Gets mapeados, gerando redundancia (passando a rota '/users' para evitar conflitos)
    // Um é o get do Wellcome e esse é o get dos usuarios
    public List<Usuario> getUsers(){ // metodo que vai listar os objetos
        return repository.findAll(); // Chamando o conponente, retorna os usuarios (objeto)
    }

    // @GetMapping("/users/{username}")  rota da requisição já endereçado em '@RequestMapping'
    @GetMapping("{username}") // passar o parametro do metodo para a URI no parametro de local{}
    public Usuario getOne(@PathVariable("username") String username){ // classificar a variavel que define o valor passado pelo parametro 'usarname'
        return repository.findByUsername(username); // buscar usuario pelo nome
    }

    // @DeleteMapping("/users/{id}") rota da requisição já endereçado em '@RequestMapping'
    @DeleteMapping("{id}") // identificado pelo parametro 'id' a URI / requisição feita usando um cliente HTTP (Postman)
    public void deleteUser(@PathVariable("id") Integer id){ // variavel 'id' passada por parametro para o mapeamento
        repository.deleteById(id);
    }

    // @PostMapping("/users") rota da requisição já endereçado em '@RequestMapping'
    @PostMapping()
    public void postUser(@RequestBody Usuario usuario){ // Spring vai pegar o json e converter em um objeto body
        repository.save(usuario);

    }
    @PutMapping()
    public void putUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }
}
