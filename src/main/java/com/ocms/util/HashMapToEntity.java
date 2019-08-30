package com.ocms.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class HashMapToEntity {
    public static Object transfer(HashMap<String,Object> map, Class<?> clazz)
    {
        if(map == null)
        {
            return null;
        }
        Object obj = null;
        try
        {
            obj = clazz.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields)
            {
                int mod = field.getModifiers();
                if(Modifier.isStatic(mod)||Modifier.isFinal(mod))
                {
                    continue;
                }
                field.setAccessible(true);
                field.set(obj,map.get(field.getName()));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return obj;
    }
}
