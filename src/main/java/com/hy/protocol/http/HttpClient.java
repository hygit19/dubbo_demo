package com.hy.protocol.http;


import com.hy.framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public String send(String hostname, int port, Invocation invocation){
        try {
            URL url = new URL("http", hostname, port,"/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            OutputStream os = httpURLConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            //接收数据
            InputStream inputStream = httpURLConnection.getInputStream();
            String result = IOUtils.toString(inputStream);

            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
