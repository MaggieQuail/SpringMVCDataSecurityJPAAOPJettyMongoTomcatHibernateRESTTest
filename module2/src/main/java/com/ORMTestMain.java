package com;

import com.configuration.SpringConfiguration;
import com.model.Auto;
import com.model.User;
import com.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.interfaces.AutoInterface;

public class ORMTestMain {

    public static void main(String[] args) {
        try {
            //Spring data test
            ApplicationContext ctx = new AnnotationConfigApplicationContext(
                SpringConfiguration.class
            );
            AutoInterface autoService = ctx.getBean(AutoInterface.class);
            System.out.println("autoService: " + autoService);
            System.out.println("autoService.method: " + autoService.someAutoMethod());

            //Hibernate test
            UserService userService = new UserService();
            User user = new User("azaza", 1);
            userService.saveUser(user);
            Auto ferrari = new Auto("Ferrari", "red");
            ferrari.setUser(user);
            user.addAuto(ferrari);
            Auto ford = new Auto("Ford", "black");
            ford.setUser(user);
            user.addAuto(ford);
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
