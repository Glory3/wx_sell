package com.xmcc.wx_sell.service;

import com.xmcc.wx_sell.common.ResultData;
import com.xmcc.wx_sell.entity.Food;
import org.springframework.stereotype.Service;

public interface ProductInfoService {
    ResultData<Food> getById(String id);

    void updateProduct(Food food);
}
