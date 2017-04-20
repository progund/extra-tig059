package com.example.withequals;

public class TestCar {

  public static void main(String[] args) {
    // Create a honda:
    Car honda = new Car("Honda");
    // Create a second honda:
    Car anotherHonda = new Car("Honda");

    // Are they the same car?
    boolean theyAreSame = honda == anotherHonda;
 
    if(theyAreSame) {
      System.out.println("They are the same car (honda == anotherHonda)");
    } else {
      System.out.println("They are two different cars (honda != anotherHonda)");
    }

    // What about equals (the one we inherited from Object)
    boolean theyAreEqual = honda.equals(anotherHonda);

    if(theyAreEqual) {
      System.out.println("The cars are to be considered equal (honda.equals(anotherHonda) )");
    } else {
      System.out.println("The cars are not to be considered equal ( !honda.equals(anotherHonda) )");
    }

    // Create another reference to the first honda:
    Car sameHonda = honda;
    System.out.println("Car sameHonda = honda;");

    // Is sameHonda referring to the same car as honda?
    boolean theyAreTheSameHonda = honda == sameHonda;
    if(theyAreTheSameHonda) {
      System.out.println("They are the same car (honda == sameHonda)");
    } else {
      System.out.println("They are two different cars");
    }

    // Are they ALSO to be considered equal?
    theyAreEqual = honda.equals(sameHonda);

    if(theyAreEqual) {
      System.out.println("The cars are to be considered equal ( honda.equals(sameHonda) )");
    } else {
      System.out.println("The cars are not to be considered equal ( !honda.equals(sameHonda) )");
    }
    
  }
}
