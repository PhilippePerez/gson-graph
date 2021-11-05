package com.pp040773.gson.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.io.File;
import java.lang.reflect.Type;

/**
 * User:  Perez Philippe
 * Date: 10/26/21
 * Time: 11:01 AM
 */
public final class FileSerializer implements JsonSerializer<File>
  {
  public JsonElement serialize(File file, Type type, JsonSerializationContext jsonSerializationContext)
    {
    if (file == null)
      {
      return null;
      }
    return new JsonPrimitive(file.getAbsolutePath());
    }
  }