package aulas_Dio.myfirstwebapi.repository;

import aulas_Dio.myfirstwebapi.handler.BusinessException;
import aulas_Dio.myfirstwebapi.handler.CampoObrigatorioException;
import aulas_Dio.myfirstwebapi.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {
    public void save(Usuario usuario){
        if(usuario.getLogin()==null) // Se o usuario não receber atributo nome, gerer exceção nome obrigatorio
            throw new CampoObrigatorioException("login");
        if(usuario.getPassword()==null) // Se a senha não receber atributo senha, gerer exceção senha obrigatorio
            throw new CampoObrigatorioException("password");

        if(usuario.getId()==null)
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        else
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório");

        System.out.println(usuario);
    }
    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        System.out.println(id);
    }
    public List<Usuario> findAll(){ // recurso de listagem de usuarios, vizualisar dados do banco de dados
        System.out.println("LIST - Listando os usários do sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("gleyson","password"));
        usuarios.add(new Usuario("frank","masterpass"));
        return usuarios;
    }
    public Usuario findById(Integer id){
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));
        return new Usuario("gleyson","password");
    }
    public Usuario findByUsername(String username){
        System.out.println(String.format("FIND/username - Recebendo o usernamae: %s para localizar um usuário", username));
        return new Usuario("gleyson","password");
    }
}