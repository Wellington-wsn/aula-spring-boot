package aula_dio.diospringsecurity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // Classe entidade (gerar objetp no banco de dados)
@Table(name = "tab_user") // Tabela do banco dedados
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração de id automatica
    @Column(name = "id_user") // nome da id na tabela
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String username;
    @Column(length = 100, nullable = false) // senha com 100 caracters, uso de criptografia
    private String password;
    @ElementCollection(fetch = FetchType.EAGER) // uso de recuesos do Spring JPA, defini uma tabela intermediaria
    @CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name = "user_id")) // para cada item da lista de usuarios(roles), tenha inserções numa nova tabela
    @Column(name = "role_id")
    private List<String> roles = new ArrayList<>();

    public User(){

    }
    public User(String username){
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
