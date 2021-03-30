package com.example.micromall.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

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

    private String detail;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    @TableField(value = "user_id")
    @ManyToOne
    private User user;

    @Transient
    private Integer userId;

}
