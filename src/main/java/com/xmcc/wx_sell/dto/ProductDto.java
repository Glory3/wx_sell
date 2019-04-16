package com.xmcc.wx_sell.dto;

import com.google.common.collect.Lists;
import com.xmcc.wx_sell.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String name;
    private Integer type;
    private List<FoodDto> foods;

    public static ProductDto build(ProductCategory category){
        ProductDto productDto = new ProductDto();
        productDto.setName(category.getCategoryName());
        productDto.setType(category.getCategoryType());
        return productDto;
    }
}
