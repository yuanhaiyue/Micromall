package com.example.micromall.entity;


import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * @author 14760
 */
@Setter
@Getter
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String image;


    private String content;

    private Integer hits;
    @Column(name = "create_time")
    private Long createTime;

    private String title;

}
