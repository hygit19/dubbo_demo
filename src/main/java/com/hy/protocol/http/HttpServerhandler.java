package com.hy.protocol.http;

import com.hy.framework.Invocation;
import com.hy.provider.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerhandler {

    public void handler(HttpServletRequest request, HttpServletResponse response) {
        //处理请求，返回结果
        try {
            InputStream inputStream = request.getInputStream();
            ObjectInputStream objectInputStream  = new ObjectInputStream(inputStream);
            //解析数据
            Invocation invocation = (Invocation) objectInputStream.readObject();

            Class implClass = LocalRegister.get(invocation.getInterfaceName());
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());

            String result =  (String)method.invoke(implClass.newInstance(), invocation.getParams());

            //返回数据
            IOUtils.write(result, response.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
