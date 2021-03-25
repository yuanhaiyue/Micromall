package com.example.micromall.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 14760
 */

@Data
public class ProductVo {
    @NotBlank(message = "不能为空")
    private String parameter;
    @NotBlank(message = "不能为空")
    private Integer id;
    @NotBlank(message = "不能为空")
    private SubCategory subCategory;
    @NotBlank(message = "不能为空")
    private String details;
    @NotBlank(message = "不能为空")
    private String name;
    @NotBlank(message = "不能为空")
    private String image;
    @NotBlank(message = "不能为空")
    private Integer price;

    public ProductVo(@NotBlank(message = "不能为空") String parameter, @NotBlank(message = "不能为空") Integer id,
                     @NotBlank(message = "不能为空") Integer price, @NotBlank(message = "不能为空") String details,
                     @NotBlank(message = "不能为空") String name, @NotBlank(message = "不能为空") String image,
                     @NotBlank(message = "不能为空") String subCategoryName,@NotBlank(message = "不能为空") Integer subCategoryId) {
        this.parameter = parameter;
        this.id = id;
        this.details = details;
        this.name = name;
        this.image = image;
        this.price = price;
        this.subCategory = new SubCategory(subCategoryId, subCategoryName);
    }
}
@AllArgsConstructor
@Data
class SubCategory{
    private Integer id;
    private String name;

}
