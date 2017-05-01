package se.juneday;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMovies {

  public static void main(String[] args) {
    List<Movie> allMovies = getMovies();
    List<Movie> results = new ArrayList<>();
    System.out.println("Movies between 1990 and 1999:");
    results = allMovies
      .stream()
      .filter( m -> {
          return m.getDetail("Year")
          .startsWith("199");
        }).collect(Collectors.toList());
    results.sort(Comparator
                 .comparing((Movie m) -> m.getDetail("Year"))
                 .thenComparing(m -> m.getDetail("Director"))
                 .thenComparing(m -> m.getDetail("Title")));
    results.forEach(System.out::println);
    
    System.out.println("=============================");
    System.out.println("David Lynch or 1990:");
    Map<String, String> map = new HashMap<>();
    map.put("Director", "David Lynch");
    map.put("Year", "1990");
    Movie.Details lynchOr1990 = new Movie.Details(map);
    results = new ArrayList<>();
    for(Movie movie : allMovies) {
      if(movie.details().matchAny(lynchOr1990)) {
        results.add(movie);
      }
    }
    results.sort(Comparator
                 .comparing((Movie m) -> m.getDetail("Year"))
                 .thenComparing(m -> m.getDetail("Director"))
                 .thenComparing(m -> m.getDetail("Title")));
    results.forEach(System.out::println);

    System.out.println("=============================");
    System.out.println("James Cameron and 1991:");
    map = new HashMap<>();
    map.put("Director", "James Cameron");
    map.put("Year", "1991");
    Movie.Details cameronAnd1991 = new Movie.Details(map);
    results = new ArrayList<>();
    for(Movie movie : allMovies) {
      if(movie.details().matchAll(cameronAnd1991)) {
        results.add(movie);
      }
    }    
    results.sort(Comparator
                 .comparing((Movie m) -> m.getDetail("Year"))
                 .thenComparing(m -> m.getDetail("Director"))
                 .thenComparing(m -> m.getDetail("Title")));
    results.forEach(System.out::println);

    System.out.println("=============================");
    System.out.println("Searching for IMDB ID tt0090756:");
    allMovies
      .stream()
      .filter(m -> m.imdbID().equals("tt0090756"))
      .forEach(System.out::println);
  }
  
  public static List<Movie> getMovies() {
    List<Movie> movies = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    Movie.Details details;
    String id;
    id = "tt0090756";
    map = new HashMap<>();
    map.put("Title", "Blue Velvet");
    map.put("Year", "1986");
    map.put("Director", "David Lynch");
    details = new Movie.Details(map);
    movies.add(new Movie(id, details));

    id = "tt0100935";
    map = new HashMap<>();
    map.put("Title", "Wild at Heart");
    map.put("Year", "1990");
    map.put("Director", "David Lynch");
    details = new Movie.Details(map);
    movies.add(new Movie(id, details));

    id = "tt0100802";
    map = new HashMap<>();
    map.put("Title", "Total Recall");
    map.put("Year", "1990");
    map.put("Director", "Paul Verhoeven");
    details = new Movie.Details(map);
    movies.add(new Movie(id, details));

    id = "tt0093870";
    map = new HashMap<>();
    map.put("Title", "RoboCop");
    map.put("Year", "1987");
    map.put("Director", "Paul Verhoeven");
    details = new Movie.Details(map);
    movies.add(new Movie(id, details));

    id = "tt0499549";
    map = new HashMap<>();
    map.put("Title", "Avatar");
    map.put("Year", "2009");
    map.put("Director", "James Cameron");
    details = new Movie.Details(map);
    movies.add(new Movie(id, details));

    id = "tt0103064";
    map = new HashMap<>();
    map.put("Title", "Terminator 2: Judgment Day");
    map.put("Year", "1991");
    map.put("Director", "James Cameron");
    details = new Movie.Details(map);
    movies.add(new Movie(id, details));

    return movies;
  }
  
}
