package com.example;

public class TestCar {

  public static void main(String[] args) {
    // Create a honda:
    Car honda = new Car("Honda");
    // Create a second honda:
    Car anotherHonda = new Car("Honda");

    // Are they the same car?
    boolean theyAreSame = honda == anotherHonda;

    if(theyAreSame) {
      System.out.println("They are the same car");
    } else {
      System.out.println("They are two different cars");
    }

    // What about equals (the one we inherited from Object)
    boolean theyAreEqual = honda.equals(anotherHonda);

    if(theyAreEqual) {
      System.out.println("The cars are to be considered equal");
    } else {
      System.out.println("The cars are not to be considered equal");
    }
  }
}
