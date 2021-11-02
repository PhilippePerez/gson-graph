package com.pp040773.gson;


import com.google.gson.*;

import java.beans.BeanInfo;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Type;
import java.util.Set;

/**
 * User:  Perez Philippe
 * Date: 11/1/21
 * Time: 2:34 PM
 */
public final class EntityJsonSerializer implements JsonSerializer
  {
  private final Set<Integer> unique;
  private final BeanInfo beanInfo;

  public EntityJsonSerializer(BeanInfo beanInfo, Set<Integer> unique)
    {
    this.unique = unique;
    this.beanInfo = beanInfo;
    }

  public JsonElement serialize(Object o, Type type, JsonSerializationContext context)
    {
    if (o == null)
      {
      return new JsonNull();
      }

    int id = System.identityHashCode(o);
    if (unique.contains(id))
      {
      return context.serialize(new Reference(id));
      }
    else
      {
      unique.add(id);
      JsonObject object = new JsonObject();
      for (PropertyDescriptor s : beanInfo.getPropertyDescriptors())
        {
        if (s.getWriteMethod() == null)
          {
          continue;
          }
        JsonElement json = null;
        try
          {
          json = context.serialize(s.getReadMethod().invoke(o));
          }
        catch (Exception e)
          {
          throw new RuntimeException(e);
          }
        object.add(s.getName(), json);
        }
      object.add("@", new JsonPrimitive(id));
      return object;
      }
    }
  }
