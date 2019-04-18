package com.xmcc.wx_sell.service.imp;

import com.xmcc.wx_sell.entity.OrderDetail;
import com.xmcc.wx_sell.repository.BatchDao;
import com.xmcc.wx_sell.repository.imp.BatchDaoImp;
import com.xmcc.wx_sell.service.OrderDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderDetailServiceImp extends BatchDaoImp implements OrderDetailService {

}
