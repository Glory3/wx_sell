package com.xmcc.wx_sell.controller;

import com.xmcc.wx_sell.common.ResultData;
import com.xmcc.wx_sell.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sell/buyer/product")
@Api(value = "产品列表接口")
public class ProductController {
    @Resource
    ProductService productService;

    @GetMapping("/list")
    @ApiOperation(value = "获取列表")
    public ResultData list(){
        return ResultData.success(productService.productList());
    }
}
