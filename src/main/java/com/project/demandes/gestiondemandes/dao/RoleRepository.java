package com.project.demandes.gestiondemandes.dao;

import com.project.demandes.gestiondemandes.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
