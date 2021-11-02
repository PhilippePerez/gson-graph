package com.pp040773.gson;


import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * User:  Perez Philippe
 * Date: 11/1/21
 * Time: 3:37 PM
 */
public final class ReferenceSerializer implements JsonSerializer
  {
  public JsonElement serialize(Object o, Type type, JsonSerializationContext context)
    {
    if (o == null)
      {
      return new JsonNull();
      }

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("@", context.serialize(((Reference) o).getId()));
    return jsonObject;
    }
  }
