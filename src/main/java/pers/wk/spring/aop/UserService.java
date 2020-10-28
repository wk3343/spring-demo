package pers.wk.spring.aop;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    public String getUser() throws IOException {
        String result = "user1";
        return result;
    }

    @Silently
    public String addUser(String userInfo) {
        if (true) {
            throw new RuntimeException("test error");
        }
        return userInfo;
    }
}
