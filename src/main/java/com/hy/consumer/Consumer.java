package com.hy.consumer;

import com.hy.framework.Invocation;
import com.hy.protocol.http.HttpClient;
import com.hy.provider.api.HelloService;

public class Consumer {

    public static void main(String[] args) {
        HttpClient httpClient  =new HttpClient();
        Invocation invocation = new Invocation(HelloService.class.getName(), "say", new Class[]{String.class}, new Object[]{"hello"});
        String str = httpClient.send("localhost", 8085, invocation);
        System.out.println(str);
    }
}
