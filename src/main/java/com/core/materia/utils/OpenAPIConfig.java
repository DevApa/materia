package com.core.materia.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@OpenAPIDefinition()
public class OpenAPIConfig {
	@Bean
    public OpenAPI configAPI() {

        return new OpenAPI ()
                .info(new Info()
                        .title("Materia")
                        .description("Mantenimiento de Materia")
                        .version("1.0.0.0")
                        .contact(new Contact()
                                .name("Carlos Aparicio Vivero")
                                .email("carlos.aparicio@ug.edu.ec")
                                .url("cmav.com")
                        )
                        .license(new License()
                                .name("http://www.gnu.org/licenses/gpl.html"))
                        )
                .externalDocs(new ExternalDocumentation()
                        .description("API Rest Secoed")
                        .url("")
                );
    }
}
