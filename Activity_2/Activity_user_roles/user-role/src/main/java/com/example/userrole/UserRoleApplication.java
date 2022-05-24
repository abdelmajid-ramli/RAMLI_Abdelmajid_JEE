package com.example.userrole;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.userrole.entities.Role;
import com.example.userrole.entities.User;
import com.example.userrole.service.UserService;

import java.util.stream.Stream;

@SpringBootApplication
public class UserRoleApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserRoleApplication.class, args);
    }
    @Bean
    CommandLineRunner start(UserService userService)
    {
       return args -> {
           User u=new User();
           u.setUserName("user1");
           u.setPwd("123453");
       userService.addNewUser(u);

           User u2=new User();
           u2.setUserName("admin");
           u2.setPwd("123453");
           userService.addNewUser(u2);

           Stream.of("STUDENT","USER","ADMIN").forEach(r->{
               Role r1=new Role();
               r1.setRoleName(r);
               userService.addNewRole(r1);
           });

           userService.addRoleToUser("user1","STUDENT");
           userService.addRoleToUser("user1","USER");
           userService.addRoleToUser("admin","USER");
           userService.addRoleToUser("admin","ADMIN");


       };
    }

}
