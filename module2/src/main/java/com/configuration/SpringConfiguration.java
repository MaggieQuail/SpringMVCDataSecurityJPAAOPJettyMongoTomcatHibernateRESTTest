package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableJpaRepositories("com.interfaces")
@ComponentScan(
        basePackages = "com"
)
public class SpringConfiguration {

    // https://stackoverflow.com/questions/21381943/how-to-configure-spring-without-persistence-xml
    // https://www.baeldung.com/java-bootstrap-jpa
    // https://vladmihalcea.com/how-to-bootstrap-jpa-programmatically-without-the-persistence-xml-configuration-file/
    @Bean
    LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("persistenceUnitPstgr");
        return factoryBean;
    }

}
