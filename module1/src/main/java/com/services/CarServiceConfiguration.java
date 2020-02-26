package com.services;

import com.annotationBeanPostProcessors.InjectAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = "com"

)
public class CarServiceConfiguration {

    @Bean
    public InjectAnnotationBeanPostProcessor injectAnnotationBeanPostProcessor() {
        return new InjectAnnotationBeanPostProcessor();
    }


}
