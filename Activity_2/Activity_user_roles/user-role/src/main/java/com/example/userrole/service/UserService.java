package com.example.userrole.service;

import com.example.userrole.entities.Role;
import com.example.userrole.entities.User;

public interface UserService {
	User addNewUser(User user); 
	Role addNewRole(Role role); 
	User findUserByUserName(String username); 
    Role findRoleByRoleName(String rolename); 
    void addRoleToUser(String username,String rolename); 
}
