package com.example.userrole.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userrole.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
 Role findByRoleName(String roleName);
}
