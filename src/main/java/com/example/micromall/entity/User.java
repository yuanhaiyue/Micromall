package com.example.micromall.entity;

import com.example.micromall.utils.Create;
import com.example.micromall.utils.Update;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

/**
 * @author 14760
 */
@NoArgsConstructor
@Setter
@Getter
@Entity
public class User {
    @NotNull(groups = Update.class)
    @Null(groups = Create.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotNull
    private String name;

    @Email
    private String email;


    @JsonIgnore
    @NotNull
    private String password;

    public User(String username, String password,String email) {
        this.name = username;
        this.password = password;
        this.email=email;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "buyer",cascade = CascadeType.DETACH)
    Set<Orders> orders;


    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.DETACH)
    Set<Contact> contacts;


}
