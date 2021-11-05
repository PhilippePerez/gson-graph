package com.pp040773.gson.deserializer;

/**
 * User:  Perez Philippe
 * Date: 11/5/21
 * Time: 3:44 PM
 */


import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.File;
import java.lang.reflect.Type;

/**
 * User:  Perez Philippe
 * Date: 10/26/21
 * Time: 11:01 AM
 */
public final class FileDeserializer implements JsonDeserializer<File>
  {
  public File deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException
    {
    if (jsonElement.isJsonNull())
      {
      return null;
      }
    return new File(jsonElement.getAsString());
    }
  }