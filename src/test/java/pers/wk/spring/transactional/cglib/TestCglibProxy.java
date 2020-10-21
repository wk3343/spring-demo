package pers.wk.spring.transactional.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;

public class TestCglibProxy {

    public static void main(String[] args) {
        //（14）生成代理类到本地
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/kewu/Documents/Java/projects/spring-demo/spring-transactional-demo/src/test/java/pers/wk/spring/transactional/cglib/debug");
        //(15)生成目标对象
        UserService userService = new UserServiceImpl();
        //（16）创建CglibProxy对象
        CglibProxy cp = new CglibProxy();
        //(17)生成代理类
        UserService proxy = (UserService) cp.getProxy(userService.getClass());

        proxy.addUser();
    }
}
