package com.example.micromall.entity;

import com.example.micromall.utils.Create;
import com.example.micromall.utils.Update;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author 14760
 */

@Getter
@Setter
@Entity
public class Category {
    @NotNull(groups = Update.class)
    @Null(groups = Create.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String name;
}
