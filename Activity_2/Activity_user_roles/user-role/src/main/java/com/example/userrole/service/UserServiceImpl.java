package com.example.userrole.service;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.example.userrole.entities.Role;
import com.example.userrole.entities.User;
import com.example.userrole.repositories.RoleRepository;
import com.example.userrole.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Service 
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {

        return userRepository.findByUserName(username);
    }

    @Override
    public Role findRoleByRoleName(String rolename) {

        return roleRepository.findByRoleName(rolename);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        User user=findUserByUserName(username);
        Role role=findRoleByRoleName(rolename);

        user.getRoles().add(role);
        role.getUsers().add(user);
        
    }
}
