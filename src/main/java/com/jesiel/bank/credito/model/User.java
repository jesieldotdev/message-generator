package com.jesiel.bank.credito.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "jbank", schema = "message_generator")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "login", nullable = false, length = 50, unique = true)
    private String login;

    @Column(name = "age", nullable = false)
    private Integer age;

    public User() {
    }

    public User(String name, String lastName, String login, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.age = age;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName() {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
