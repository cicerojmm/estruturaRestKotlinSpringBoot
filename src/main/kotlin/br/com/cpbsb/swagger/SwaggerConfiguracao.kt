package br.com.cpbsb.swagger

import br.com.cpbsb.constantes.VERSAO_API
import com.google.common.base.Predicates
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfiguracao {

    @Bean
    fun productApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("br.com.cpbsb.resources"))
                .paths(Predicates.not(PathSelectors.regex("/login")))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
    }

    fun apiInfo(): ApiInfo {
        return ApiInfoBuilder().title("Example API")
                .description("Estrutura de uma API RestFull com Spring Boot e Swagger")
                .version(VERSAO_API).build();
    }
}