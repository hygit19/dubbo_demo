package com.hy.provider.impl;

import com.hy.provider.api.HelloService;

public class HelloServiceImpl implements HelloService {


    @Override
    public Object say(String content) {
        System.out.println("doing： "+content);
        return "doing "+content;
    }
}
