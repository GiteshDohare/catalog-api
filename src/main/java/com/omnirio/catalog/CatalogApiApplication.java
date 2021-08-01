package com.omnirio.catalog;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CatalogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogApiApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Catalog API")
                        .version("1.0")
                        .description("Catalog API for creating categories, attributes and products")
                        .contact(new Contact().name("Giteshkumar Dohare").email("gitesh.dohare@gmail.com").url("https://github.com/giteshkumar94/catalog-api")));

    }


}
