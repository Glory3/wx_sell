package com.xmcc.wx_sell.repository;

import com.xmcc.wx_sell.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, String> {

}
