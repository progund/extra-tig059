package com.example.comparable;

public class Car implements Comparable<Car> {

  private String make;
  private double price;
  private int horsePowers;
  
  public Car(String make, double price, int horsePowers) {
    this.make = make;
    this.price = price;
    this.horsePowers = horsePowers;
  }

  public String make() {
    return make;
  }
  
  public double price() {
    return price;
  }

  public int horsePowers() {
    return horsePowers;
  }
  
  @Override
  public String toString() {
    return make + " with " + horsePowers + "hp - for only "
      + String.format("%.2f", price);
  }

  @Override
  public int compareTo(Car other) {
    return (int) (price - other.price);
  }
}
