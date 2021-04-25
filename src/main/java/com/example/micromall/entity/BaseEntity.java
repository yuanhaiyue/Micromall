package com.example.micromall.entity;


import com.example.micromall.utils.Create;
import com.example.micromall.utils.Update;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Date;

/**
 * @author swxu_2005@163.com
 * @date 2019/5/7
 */
@Data
@DynamicInsert
@DynamicUpdate
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotNull(groups = Update.class)
  @Null(groups = Create.class)
  private Long id;

  /**
   * 创建时间
   */
  @CreatedDate
  private Date createTime;

  private Long creator;


  /**
   * 修改时间
   */
  @LastModifiedDate
  private Date updateTime;

  private Long updater;

}
