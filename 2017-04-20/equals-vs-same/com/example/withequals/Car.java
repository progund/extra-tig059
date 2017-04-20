package com.example.withequals;

public class Car {

  private String make;

  public Car(String make) {
    this.make = make;
  }

  public String make() {
    return make;
  }

  @Override
  public String toString() {
    return "A car made by " + make;
  }

  @Override
  public boolean equals(Object other){
    // Is the other object even a Car?
    if(! (other instanceof Car) ) {
      return false;
    }
    // Is it the exact same car?
    if(other == this) {
      return true;
    }
    // It is at least a car. Is it the same make?
    return ((Car)other).make.equals(this.make);
  }
}
