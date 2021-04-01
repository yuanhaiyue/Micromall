package com.example.micromall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
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
@TableName
public class Contact {
    @TableId(type=IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;

    private String name;

    private String phoneNumber;

    private String detail;

    private Date createTime;

    private Date updateTime;

    @TableField(exist = false)
    @JsonIgnore
    @ManyToOne
    private User user;
    @TableField(value = "user_id")
    @Transient
    private Integer userId;

}
