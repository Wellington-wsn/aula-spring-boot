package aulas_Dio.myfirstwebapi.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration // clasificando a Classe como configuração
@EnableSwagger2 // abilitar documentação do Swagger
public class SwaggerConfig {
    private Contact contato() { // Metodo para retorno de contato
        return new Contact(
                "Wellington",
                "http://www.site.com.br",
                "fogosark@hotmail.com");
    }
    private ApiInfoBuilder informacoesApi() { // metodo de retorno das informações da API

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Aula DIO Swegger - Rest API");
        apiInfoBuilder.description("API exemplo de uso de Springboot REST API");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.license("Licença - Sua Empresa");
        apiInfoBuilder.licenseUrl("http://www.seusite.com.br");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;
    }
    // Como se trata de uma aplicação Springboot, vamos criar um Docket (documento) em forma de @Bean
    @Bean
    public Docket detalheApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket // Consumir e produzier e json
                .select()
                .apis(RequestHandlerSelectors.basePackage("aulas_Dio.myfirstwebapi.controller")) // direcionamento para o pacotes principal dos controlles para o swagger montar a pagina de documentação
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }
}
