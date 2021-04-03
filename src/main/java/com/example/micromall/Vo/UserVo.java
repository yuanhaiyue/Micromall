package com.example.micromall.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author 14760
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class UserVo implements Serializable {
    private Integer id;
    private String name;

}
