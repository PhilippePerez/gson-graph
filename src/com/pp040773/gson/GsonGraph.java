package com.pp040773.gson;


import com.google.gson.GsonBuilder;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.HashMap;
import java.util.HashSet;

/**
 * User:  Perez Philippe
 * Date: 10/26/21
 * Time: 10:59 AM
 */
public final class GsonGraph
  {
  private GsonGraph()
    {
    }

  public static GsonBuilder builder(Class... entities)
    {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(Reference.class, new ReferenceSerializer());
    builder.registerTypeAdapter(Reference.class, new ReferenceDeserializer());

    for (Class entity : entities)
      {
      BeanInfo beanInfo = null;
      try
        {
        beanInfo = Introspector.getBeanInfo(entity);
        }
      catch (IntrospectionException e)
        {
        throw new RuntimeException(e);
        }

      builder.registerTypeAdapter(entity, new EntityJsonDeserializer(entity, new HashMap<Integer, Object>(), beanInfo));
      builder.registerTypeAdapter(entity, new EntityJsonSerializer(beanInfo, new HashSet<Integer>()));
      }
    return builder;
    }
  }
