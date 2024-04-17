package Aula.Dio.diospringsecurityjwt.dtos;

public class Login { // Acesso para realoizar o token e receber para as requisições
    private String username;
    private String password;

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
}
