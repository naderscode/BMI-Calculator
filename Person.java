// Created by Nader K
//
// Date: 10/17/2013
// Filename: Person.java


public class Person
{

   private String name;
   
   public Person()
   {
      name = "";
   }//end constructor
   
   public Person(String n)
   {
      name = n;
   
   }
   
   public void setName(String n)
   {
      name = n;
   }
   
   public String getName()
   {
      return name;
   
   }
   
   public String toString()
   {
      return "This is a person. The name is: " + getName()+". ";   
   }

}//end class Person
