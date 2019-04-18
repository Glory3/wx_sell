package com.xmcc.wx_sell.service.imp;


import com.xmcc.wx_sell.common.ProductEnum;
import com.xmcc.wx_sell.common.ResultData;
import com.xmcc.wx_sell.common.ResultEnum;
import com.xmcc.wx_sell.entity.Food;
import com.xmcc.wx_sell.repository.FoodRepository;
import com.xmcc.wx_sell.service.ProductInfoService;
import com.xmcc.wx_sell.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductInfoServiceImp implements ProductInfoService {
    @Autowired
    private ProductService productCategoryService;
    @Autowired
    private FoodRepository productInfoRepository;

    @Override
    public ResultData<Food> getById(String productId) {
        //使用common-lang3 jar的类 没导入自己导入一下
        if(StringUtils.isBlank(productId)){
            return ResultData.faile(ResultEnum.FAILE.getMsg()+":"+productId);
        }
        Optional<Food> byId = productInfoRepository.findById(productId);
        if(!byId.isPresent()){
            return ResultData.faile(productId+":"+ResultEnum.NOT_EXITS.getMsg());
        }
        Food productInfo = byId.get();
        //判断商品是否下架
        if(productInfo.getProductStatus()== ProductEnum.PRODUCT_DOWN.getCode()){
            return ResultData.faile(ProductEnum.PRODUCT_DOWN.getMsg());
        }

        return ResultData.success(productInfo);
    }

    @Override
    @Transactional
    public void updateProduct(Food productInfo) {
        productInfoRepository.save(productInfo);
    }
}
