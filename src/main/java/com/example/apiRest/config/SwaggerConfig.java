package com.example.apiRest.config;

import com.example.apiRest.model.User;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;
import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket filmAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.apiRest"))
                .paths(regex("/*.*"))
                .build()
                .ignoredParameterTypes(User.class);
                //.apiInfo(metaInfo());
    }

//    private ApiInfo metaInfo() {
//
//        ApiInfo apiInfo = new ApiInfo(
//                "Films API Rest",
//                "API for register and control of films.",
//                "1.0",
//                "Terms of Service",
//                new Contact("Os Guri", "https://www.youtube.com/osguri",
//                        "project.api.git@gmail.com"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
//        );
//
//        return apiInfo;
//    }

}
