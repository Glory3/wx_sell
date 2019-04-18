package com.xmcc.wx_sell.controller;

import com.google.common.collect.Maps;
import com.xmcc.wx_sell.common.ResultData;
import com.xmcc.wx_sell.dto.OrderMasterDto;
import com.xmcc.wx_sell.service.OrderMasterService;
import com.xmcc.wx_sell.service.imp.OrderMasterServiceImp;
import com.xmcc.wx_sell.utils.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/sell/buyer/order")
@Api(value = "订单相关接口",description = "完成订单的增删改查")
public class OrderMasterController {
    @Autowired
    private OrderMasterService orderMasterService;

    @PostMapping("/create")
    @ApiOperation(value = "创建订单接口", httpMethod = "POST", response = ResultData.class)
    //@Valid配合刚才在DTO上的JSR303注解完成校验
    //注意：JSR303的注解默认是在Contorller层进行校验
    //如果想在service层进行校验 需要使用javax.validation.Validator  也就是上个项目用到的工具
    public ResultData create(@Valid @ApiParam(name="订单对象",value = "传入json格式",required = true) OrderMasterDto orderMasterDto, BindingResult bindingResult){
        Map<String,String> map = Maps.newHashMap();
        //判断是否有参数校验问题
        if(bindingResult.hasErrors()){
            List<String> errList = bindingResult.getFieldErrors().stream().map(err -> err.getDefaultMessage()).collect(Collectors.toList());
            map.put("参数校验错误", JsonUtil.object2string(errList));
            //将参数校验的错误信息返回给前台
            return  ResultData.faile(map);
        }
        return orderMasterService.insertOrder(orderMasterDto);
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取列表")
    public ResultData list(String openid, Integer page, Integer size){
        return orderMasterService.list(page, size);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "获取详情")
    public ResultData detail(String openid, String orderId){
        return orderMasterService.detail(openid, orderId);
    }

    @PostMapping("/cancel")
    @ApiOperation(value = "取消订单")
    public ResultData cancel(String openid, String orderId){
        return orderMasterService.cancel(openid, orderId);
    }
}
