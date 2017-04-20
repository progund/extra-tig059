package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Arrays.asList;

public class TestCar {

  public static void main(String[] args) {
    List<Car> allCars = getAllCars();
    System.out.println("All cars: " + allCars);
    // Collections.sort(allCars); // Won't compile, Car is not Comparable!
    System.out.println("Sorting car using a Comparator for make");
    Collections.sort(allCars, new CarMakeComparator());
    System.out.println("All cars: " + allCars);
    
  }

  public static List<Car> getAllCars() {
    return
      asList(
             new Car("Honda"),
             new Car("BMW"),
             new Car("Porche"),
             new Car("Berlingo")
             );
  }
  
}
