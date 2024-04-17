package AulasDio.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
	// Inicialização é disparada para CommandlineRuuner (recurso do spring) na classe StarApp - executa automaticamento ao iniciar o conteiner
	// Versoã do H2 (banco de dados) bug de id gerenciado pelo banco.
}
