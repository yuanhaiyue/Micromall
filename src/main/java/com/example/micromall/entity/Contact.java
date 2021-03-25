package com.example.micromall.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author 14760
 */

@Getter
@Setter
@Entity

public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;

    private String name;

    private String phoneNumber;
    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;




}
