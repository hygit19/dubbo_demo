package com.hy.register;

import com.hy.framework.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteMapRegister {

    private static Map<String, List<URL>> map = new HashMap<>();

    public static void register(String interfaceName, URL url){
        List<URL> list = map.get(interfaceName);
        if(list == null){
            List<URL> createList = new ArrayList<>();
            createList.add(url);
            map.put(interfaceName, list);
        }else{
            list.add(url);
        }
    }

}
