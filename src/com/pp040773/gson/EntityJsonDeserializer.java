package com.pp040773.gson;


import com.google.gson.*;

import java.beans.BeanInfo;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * User:  Perez Philippe
 * Date: 11/1/21
 * Time: 2:27 PM
 */
public final class EntityJsonDeserializer implements JsonDeserializer
  {
  private final Map<Integer, Object> graph;
  private final Class entity;
  private final BeanInfo beanInfo;

  public EntityJsonDeserializer(Class entity, Map<Integer, Object> graph, BeanInfo beanInfo)
    {
    this.graph = graph;
    this.entity = entity;
    this.beanInfo = beanInfo;
    }

  public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException
    {
    JsonObject object = (JsonObject) jsonElement;
    int id = object.getAsJsonPrimitive("@").getAsInt();
    if (object.entrySet().size() == 1)
      {
      return graph.get(id);
      }
    else
      {
      try
        {
        Object instance = entity.newInstance();
        graph.put(id, instance);

        for (PropertyDescriptor p : beanInfo.getPropertyDescriptors())
          {
          if (p.getWriteMethod() == null)
            {
            continue;
            }

          JsonElement jsonElement1 = ((JsonObject) jsonElement).get(p.getName());
          Field declaredField = entity.getDeclaredField(p.getName());
          declaredField.setAccessible(true);
          Type javaType = declaredField.getGenericType();
          Object v = context.deserialize(jsonElement1, javaType);
          p.getWriteMethod().invoke(instance, v);
          }
        return instance;
        }
      catch (Exception e)
        {
        throw new RuntimeException(e);
        }
      }
    }
  }
