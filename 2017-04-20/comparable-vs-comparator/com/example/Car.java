package com.example;

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
}
