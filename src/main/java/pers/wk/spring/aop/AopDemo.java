package pers.wk.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class AopDemo {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        String user = userService.getUser();

        userService.addUser("testuser");
    }
}
