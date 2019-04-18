package com.xmcc.wx_sell.dto;

import com.xmcc.wx_sell.common.OrderEnum;
import com.xmcc.wx_sell.common.PayEnum;
import com.xmcc.wx_sell.entity.OrderMaster;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMasterListDto {
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus = OrderEnum.NEW.getCode();

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus = PayEnum.WAIT.getCode();

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;

    private List<OrderDetailListDto> orderDetailList;

    public static OrderMasterListDto build(OrderMaster order){
        OrderMasterListDto o = new OrderMasterListDto();
        o.setOrderDetailList(null);
        BeanUtils.copyProperties(order, o);
        return o;
    }

}
