package com.xmcc.wx_sell.service;

import com.xmcc.wx_sell.common.ResultData;
import com.xmcc.wx_sell.dto.OrderMasterDto;

public interface OrderMasterService {
    ResultData insertOrder(OrderMasterDto order);
    ResultData list(Integer page, Integer size);

    ResultData detail(String openid, String orderId);

    ResultData cancel(String openid, String orderId);
}
