package com.xmcc.wx_sell.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xmcc.wx_sell.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    //返回json的属性名跟属性名不一致 我又希望见名知意 用这个注解转换
    @JsonProperty("id")
    private String productId;

    /** 名字. */
    @JsonProperty("name")
    private String productName;

    /** 单价. */
    @JsonProperty("price")
    private BigDecimal productPrice;


    /** 描述. */
    @JsonProperty("description")
    private String productDescription;

    /** 小图. */
    @JsonProperty("icon")
    private String productIcon;

    public static FoodDto build(Food food){
        FoodDto foodDto = new FoodDto();
        BeanUtils.copyProperties(food, foodDto);
        return foodDto;
    }
}
