package pard.thirdSeminar.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;

import java.awt.*;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().components(new Components()).info(apiInfo());
    }

    private Info apiInfo() {
        return new Info().title("sfssdfsf").description("safsssss").version("1.0.0");

    }
}
