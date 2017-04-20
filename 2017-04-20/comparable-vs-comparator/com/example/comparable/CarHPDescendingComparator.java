package com.example.comparable;

import java.util.Comparator;

public class CarHPDescendingComparator implements Comparator<Car> {
  @Override
  public int compare(Car car1, Car car2) {
    return car2.horsePowers() - car1.horsePowers();
  }
}
