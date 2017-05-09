import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {

  private String name;
  // NOTE: It is not wise to store age in a variable
  // since age is a function of birth date and current date
  // but let's pretend this person never has a birthday and
  // the age always remains the same.
  private int age;
  private double weight;

  public Person(String name, int age, double weight) {
    this.age = age;
    this.name = name;
    this.weight = weight;
  }

  public String name() {
    return name;
  }

  public int age() {
    return age; // this person never gets any older
  }

  public double weight() {
    return weight;
  }

  @Override
  public String toString() {
    return new StringBuilder(name)
      .append(" ")
      .append(age)
      .append(" years old ")
      .append(weight)
      .append(" kg")
      .toString();
  }
}
class TestPerson {

  /* This method should perhaps rather be called
   * readPersonsFromUser() or something similar
   * which actually describes what this method does.
   * 
   * At least, it should be called initPersons() with
   * a plural s - since a List<Person> can contain more
   * than one Person references....
   *
   * We really should have error handling, but the
   * exam question probably wanted to test something
   * else, so we skip it.
   *
   * However, we really SHOULD have error handling.
   */
  static List<Person> initPerson() {
    Scanner sc = new Scanner(System.in);
    List<Person> persons = new ArrayList<>();
    System.out.println("Welcome.");
    System.out.println("Quit by entering 'sluta' as the name.");
    boolean readMorePersons = true;
    while (readMorePersons) {
      System.out.print("Name: ");
      String name = sc.nextLine();
      if ("sluta".equals(name)) {
        readMorePersons = false;
        continue;
      }
      System.out.print("Age: ");
      int age = Integer.parseInt(sc.nextLine());
      System.out.print("Weight (use . as decimal point): ");
      double weight = Double.parseDouble(sc.nextLine());
      persons.add(new Person(name, age, weight));
    }
    return persons;
  }
  
  public static void main(String[] args) {
    List<Person> persons = initPerson();
    System.out.println(persons);
  }
  /*
Test runs:
$ javac Person.java && java TestPerson
Welcome.
Quit by entering 'sluta' as the name.
Name: Henrik
Age: 46
Weight (use . as decimal point): 85.2
Name: Rikard
Age: 45
Weight (use . as decimal point): 85
Name: sluta
[Henrik 46 years old 85.2 kg, Rikard 45 years old 85.0 kg]

// Enter zero persons:
$ javac Person.java && java TestPerson
Welcome.
Quit by entering 'sluta' as the name.
Name: sluta
[]

// Proof of why we really should have error handling:
$ javac Person.java && java TestPerson
Welcome.
Quit by entering 'sluta' as the name.
Name: 1123
Age: lastgammal
Exception in thread "main" java.lang.NumberFormatException: For input string: "lastgammal"
at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
at java.lang.Integer.parseInt(Integer.java:580)
at java.lang.Integer.parseInt(Integer.java:615)
at TestPerson.initPerson(Person.java:74)
at TestPerson.main(Person.java:83)
  */
}
