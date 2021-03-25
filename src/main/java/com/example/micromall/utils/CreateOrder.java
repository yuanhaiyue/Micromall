package com.example.micromall.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author 14760
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class CreateOrder{
    @NotBlank(message = "不能为空")
    private Integer amount;
    @NotBlank(message = "不能为空")
    private String remarks;
    @NotBlank(message = "不能为空")
    private Integer freight;
    @NotBlank(message = "不能为空")
    private Integer productId;
    @NotBlank(message = "不能为空")
    private Integer buyerId;
}
