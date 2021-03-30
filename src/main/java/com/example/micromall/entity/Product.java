package com.example.micromall.entity;

import com.example.micromall.utils.Create;
import com.example.micromall.utils.Update;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * @author 14760
 */
@Getter
@Setter
@Entity
public class Product {
    @NotNull(groups = Update.class)
    @Null(groups = Create.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String name;
    private String image;
    private Integer price;
    private String parameter;
    private String details;

    private String sellPoint;
    private Integer num;
    private String content;
    private Integer status;

    private Date deleteTime;
    private Date createTime;
    private Date updateTime;


    @OneToMany(mappedBy = "product")
    private List<Album> album;

    @JoinColumn(name = "sub_category_id")
    @JsonIgnoreProperties(value = {"name","category","image"})
    @ManyToOne
    private SubCategory subCategory;


}
