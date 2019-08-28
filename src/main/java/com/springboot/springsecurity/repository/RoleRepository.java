package com.springboot.springsecurity.repository;

import com.springboot.springsecurity.model.Role;
import com.springboot.springsecurity.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);

}
