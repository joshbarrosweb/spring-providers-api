package com.joshbarros.springproviders.cmd;

import com.joshbarros.springproviders.entities.User;
import com.joshbarros.springproviders.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.joshbarros.springproviders.enums.RoleEnum.ADMIN;

@Component
public class UserInitializer implements CommandLineRunner {

    private final UserService userService;

    public UserInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        /* User user = new User();
        user.setEmail("joshbarrosweb@gmail.com");
        user.setEnabled(true);
        user.setFirstName("Josue");
        user.setLastName("Barros");
        user.setLocked(false);
        user.setPassword("12345678");
        user.setUserRole(ADMIN);
        user.setUsername("josuebarros1995");
        user.setId(1L);
        User savedUser = userService.save(user); */

        System.out.println("NO DATA TO LOAD");
    }
}
