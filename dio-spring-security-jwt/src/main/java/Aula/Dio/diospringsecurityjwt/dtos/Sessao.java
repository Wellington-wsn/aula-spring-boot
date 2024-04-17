package Aula.Dio.diospringsecurityjwt.dtos;

public class Sessao { // retornar login do usuario e o token (resultado de tentativa de autenticação)
    private String login;
    private String token;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
