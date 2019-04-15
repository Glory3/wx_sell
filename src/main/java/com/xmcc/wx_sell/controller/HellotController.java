package com.xmcc.wx_sell.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HellotController {
    Logger logger = LoggerFactory.getLogger(HellotController.class);
    @RequestMapping("/say")
    public String say(){
        logger.info("1231123");
        return "hello spring boot";
    }
}
