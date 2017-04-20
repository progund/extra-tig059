package com.example.comparable;

import java.util.Comparator;

public class CarHPComparator implements Comparator<Car> {
  @Override
  public int compare(Car car1, Car car2) {
    return car1.horsePowers() - car2.horsePowers();
  }
}
