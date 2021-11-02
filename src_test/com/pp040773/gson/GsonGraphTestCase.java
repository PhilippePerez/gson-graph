package com.pp040773.gson;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * User:  Perez Philippe
 * Date: 11/2/21
 * Time: 8:54 AM
 */
public class GsonGraphTestCase extends TestCase
  {
  public void test1()
    {
    Company company = new Company();
    List<User> coders = new ArrayList<User>();
    company.setCoders(coders);
    User mikeBrown = new User("mike", "brown");
    coders.add(mikeBrown);
    coders.add(mikeBrown);
    coders.add(new User("kirk", "white"));
    coders.add(new User("kirk", "white"));
    String json = GsonGraph.builder(Company.class, Group.class, User.class).create().toJson(company);

    Company read = GsonGraph.builder(Company.class, Group.class, User.class).create().fromJson(json, Company.class);

    assertSame(read.getCoders().get(0), read.getCoders().get(1));
    }

  public static final class User
    {
    private String firstName;
    private String lastName;

    public User()
      {
      }

    public User(String firstName, String lastName)
      {
      this.firstName = firstName;
      this.lastName = lastName;
      }

    public void setFirstName(String firstName)
      {
      this.firstName = firstName;
      }

    public void setLastName(String lastName)
      {
      this.lastName = lastName;
      }

    public String getFirstName()
      {
      return firstName;
      }

    public String getLastName()
      {
      return lastName;
      }
    }

  public static final class Group
    {
    private List<User> users;
    private String name;

    public String getName()
      {
      return name;
      }

    public void setName(String name)
      {
      this.name = name;
      }

    public List<User> getUsers()
      {
      return users;
      }

    public void setUsers(List<User> users)
      {
      this.users = users;
      }
    }

  public static final class Company
    {
    private List<User> coders;
    private String name;

    public String getName()
      {
      return name;
      }

    public void setName(String name)
      {
      this.name = name;
      }

    public List<User> getCoders()
      {
      return coders;
      }

    public void setCoders(List<User> coders)
      {
      this.coders = coders;
      }
    }
  }
