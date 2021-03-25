package com.example.micromall.entity;

import com.example.micromall.utils.Create;
import com.example.micromall.utils.Update;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Date;

/**
 * @author 14760
 */

@Setter
@Getter
@Entity
public class Orders {
    @NotNull(groups = Update.class)
    @Null(groups = Create.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String states;

    private Integer createTime;

    private String remarks;

    private Integer freight;

    private Integer amount;

    private Integer total;

    @JsonIgnore
    @JoinColumn(name = "buyer_id")
    @ManyToOne
    private User buyer;
    @JsonIgnore
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;
}
