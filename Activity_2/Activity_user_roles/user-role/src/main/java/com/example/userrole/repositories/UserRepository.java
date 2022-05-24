package com.example.userrole.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.example.userrole.entities.User;

@Repository
@RestResource
public interface UserRepository extends JpaRepository<User,String>{
    User findByUserName(String userName);

}
