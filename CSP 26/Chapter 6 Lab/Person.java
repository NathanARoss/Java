/**
   Define a Person class and test it's functionality
   @author Nathan Ross
*/

public class Person
{
   String name;
   int age;
   String gender;
   
   public Person() {
      name = "";
      age = 0;
      gender = "";
   }
   
   public Person(String name, int age, String gender) {
      this.name = name;
      this.age = age;
      this.gender = gender;
   }
   
   public String getName() {
      return name;
   }
   
   public int getAge() {
      return age;
   }
   
   public String getGender() {
      return gender;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public void setAge(int age) {
      this.age = age;
   }
   
   public void setGender(String gender) {
      this.gender = gender;
   }
   
   /**
      Test Person class functionality
      @param args array of arguments (unused)
   */
   public static void main(String [] args)
   {
      Person people[] = new Person[2];
      
      people[0] = new Person();
      people[1] = new Person("Nathan", 20, "Attack Helicopter");
      
      for (Person person : people)
      {
         System.out.printf(
         "Name: %s%n" +
         "Age: %d%n" +
         "Gender: %s%n%n",
         person.getName(), person.getAge(), person.getGender());
      }
      
      System.out.println("Performing sex change surgery.");
      System.out.println();
      
      people[0].setName("Timmy");
      people[0].setAge(7);
      people[0].setGender("Male");
      
      people[1].setGender("Central Processor");
      
      for (Person person : people)
      {
         System.out.printf(
         "Name: %s%n" +
         "Age: %d%n" +
         "Gender: %s%n%n",
         person.getName(), person.getAge(), person.getGender());
      }
   }
}