package com.example.micromall.entity;



import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author 14760
 */
@Setter
@Getter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String image;

    private String abstracts;
    private String content;

    private Integer hits;
    @Column(name = "create_time")
    private Long createTime;

    private String title;

}
