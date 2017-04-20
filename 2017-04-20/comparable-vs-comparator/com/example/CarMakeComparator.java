package com.example;

import java.util.Comparator;

public class CarMakeComparator implements Comparator<Car> {
  @Override
  public int compare(Car car1, Car car2) {
    // Make is a String, and String is comparable!
    return car1.make()
      .compareTo(car2.make());
  }
}
