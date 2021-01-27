package com.hy.provider;

import java.util.HashMap;
import java.util.Map;

public class LocalRegister {

    private static Map<String, Class> map = new HashMap<>();

    public static void regist(String intefaceName, Class implClass){
        map.put(intefaceName, implClass);
    }

    public static Class get(String intefaceName){
        return map.get(intefaceName);
    }
}
