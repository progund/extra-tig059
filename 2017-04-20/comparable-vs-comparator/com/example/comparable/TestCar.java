package com.example.comparable;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Arrays.asList;

public class TestCar {

  public static void main(String[] args) {
    List<Car> allCars = getAllCars();
    System.out.println("All cars: " + allCars);
    System.out.println("Sorting car the natural comparison for price");
    Collections.sort(allCars);    
    System.out.println("All cars: " + allCars);
    System.out.println("\n==============\n");
    System.out.println("But if we don't want to compare using price?");
    System.out.println("We can use the sort which uses a custom Comparator!");
    System.out.println("Sorting car using a Comparator for horse powers");
    Collections.sort(allCars, new CarHPComparator());
    System.out.println("All cars: " + allCars);
    System.out.println("\n==============\n");
    System.out.println("We want the highest horse power first, so let's use");
    System.out.println("a comparator for horse power descending order.");
    Collections.sort(allCars, new CarHPDescendingComparator());
    System.out.println("All cars: " + allCars);
  }

  public static List<Car> getAllCars() {
    return
      asList(
             new Car("Honda", 20_000.0, 80),
             new Car("BMW", 300_000.0, 350),
             new Car("Porche", 400_000.0, 300),
             new Car("Berlingo", 10_000, 9)
             );
  }
  
}
