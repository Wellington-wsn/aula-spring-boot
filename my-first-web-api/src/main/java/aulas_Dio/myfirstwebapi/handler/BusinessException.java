package aulas_Dio.myfirstwebapi.handler;

public class BusinessException extends RuntimeException {  // retonar mensagens mapeadas em código HTTP
    public BusinessException(String mensagem) {
        super(mensagem);
    }
    public BusinessException(String mensagem, Object ... params) { // uso do ... varargs, permite numeros variaveis de argumentos
        super(String.format(mensagem, params));
    }
}