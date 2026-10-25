package com.example.SpringSecurity2.service;

import com.example.SpringSecurity2.entity.Role;
import com.example.SpringSecurity2.repository.RoleRepository;
import org.springframework.stereotype.Service;


@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }
    public void addRole(Role role){
        roleRepository.save(role);
    }
}
