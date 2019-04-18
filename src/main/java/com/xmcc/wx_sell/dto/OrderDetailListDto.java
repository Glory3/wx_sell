package com.xmcc.wx_sell.dto;

import com.xmcc.wx_sell.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailListDto {
    private String detailId;

    /** 订单id. */
    private String orderId;

    /** 商品id. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品单价. */
    private BigDecimal productPrice;

    /** 商品数量. */
    private Integer productQuantity;

    /** 商品小图. */
    private String productIcon;

    /** 商品大图. */
    private String productImage;

    public static OrderDetailListDto build(OrderDetail d){
        OrderDetailListDto o = new OrderDetailListDto();
        BeanUtils.copyProperties(d, o);
        o.setProductImage(o.getProductIcon());
        return o;
    }
}
