package com.pp040773.gson;

/**
 * User:  Perez Philippe
 * Date: 11/1/21
 * Time: 3:18 PM
 */
final public class Reference
  {
  private final int id;

  public Reference(int id)
    {
    this.id = id;
    }

  public int getId()
    {
    return id;
    }

  @Override
  public boolean equals(Object o)
    {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Reference reference = (Reference) o;

    return id == reference.id;
    }

  @Override
  public int hashCode()
    {
    return id;
    }
  }
