package com.ocms.util;

import java.lang.reflect.Field;
import java.util.HashMap;

public class EntityToHashMapUtil {
    public static HashMap<String,Object> transfer(Object obj)
    {
        HashMap<String,Object> res = new HashMap<>();
        Class<?> clazz = obj.getClass();
        try
        {
            for (
                    Field field:
                    clazz.getDeclaredFields())
            {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(obj);
                res.put(fieldName,value);
            }
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return res;
    }
}
