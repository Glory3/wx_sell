package com.xmcc.wx_sell.service;

import com.xmcc.wx_sell.dto.FoodDto;
import com.xmcc.wx_sell.dto.ProductDto;
import com.xmcc.wx_sell.entity.Food;
import com.xmcc.wx_sell.entity.ProductCategory;
import com.xmcc.wx_sell.repository.FoodRepository;
import com.xmcc.wx_sell.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Resource
    ProductCategoryRepository productCategoryRepository;

    @Resource
    FoodRepository foodRepository;

    public List<ProductDto> productList(){
        List<ProductCategory> categories = productCategoryRepository.findAll();
        List<Food> foods = foodRepository.findAll();

        return categories.parallelStream().map(categorie -> {
            ProductDto productDto = ProductDto.build(categorie);
            productDto.setFoods(foods.parallelStream().filter(food -> food.getCategoryType() == productDto.getType()).map(food -> FoodDto.build(food)).collect(Collectors.toList()));
            return productDto;
        }).collect(Collectors.toList());
    }


}
