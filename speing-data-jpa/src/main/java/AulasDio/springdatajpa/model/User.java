package AulasDio.springdatajpa.model;

import jakarta.persistence.*;

@Entity  // Uso em aplicação com JPA com entidades
public class User { // POJO
    @Id // Classificar a propriedade id como identidade no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gerencia o id de forma automatica com o banco de dados, uma estrutura de identificação (ao criar um usuario gera um id automatico)
    @Column(name = "user_id") // nome dado a coluna do id
    private Integer id;

    @Column(length = 50, nullable = false) // Configuração da coluna name, largura 50 character e não nula
    private String name;
    @Column(length = 20, nullable = false)
    private String username;
    @Column(length = 100, nullable = false)
    private String password;

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

    @Override  // (sobrepor)
    public String toString() { // retornar o objeto com os dados classificados, não como relacionamento (instancia na memoria)
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
