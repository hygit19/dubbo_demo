package com.hy.provider;

import com.hy.framework.URL;
import com.hy.protocol.http.HttpServer;
import com.hy.provider.api.HelloService;
import com.hy.provider.impl.HelloServiceImpl;
import com.hy.register.RemoteMapRegister;

public class Provider {


    public static void main(String[] args) {

        //1.本地注册 {服务名： 实现类}
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        //2.远程注册
        RemoteMapRegister.register(HelloService.class.getName(), new URL("localhost", 8085));

        //3.启动tomcat
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8085);

        System.out.println("启动成功！！！");
    }
}
