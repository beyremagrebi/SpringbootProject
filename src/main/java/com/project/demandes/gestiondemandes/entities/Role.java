package com.project.demandes.gestiondemandes.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Role(String name) {
        super();
        this.name=name;
    }
    public Role(){

    }
}