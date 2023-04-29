package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    @Column(unique = true)
    private String name;

    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user_question",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<User> questions;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles=new HashSet<>();

    public User(){

    }


    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public List<User> getQuestions() {
        return questions;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setQuestions(List<User> questions) {
        this.questions = questions;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public void addRole(Role role){
        if (roles == null){
            this.roles = new HashSet<>();
        }
        this.roles.add(role);
    }
}