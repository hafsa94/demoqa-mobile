package org.demoqa.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheUtils {

    public static Map<String, Object> cacheMap = new ConcurrentHashMap<>();

    public static void put(String key, Object value) {
        cacheMap.put(key, value);
    }

    public static Object getValue(String key) {
        return cacheMap.get(key);
    }
}
