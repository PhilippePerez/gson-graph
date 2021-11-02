package com.pp040773.gson;


import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * User:  Perez Philippe
 * Date: 11/1/21
 * Time: 3:40 PM
 */
public final class ReferenceDeserializer implements JsonDeserializer
  {
  public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException
    {
    return null;
    }
  }
