package aulas_Dio.myfirstwebapi.handler;

public class CampoObrigatorioException extends BusinessException{
    public CampoObrigatorioException(String campo) { //cria uma exceção para muitos campos obrigatorios
        super("O campo %s é obrigatorio!", campo);
    }
}
