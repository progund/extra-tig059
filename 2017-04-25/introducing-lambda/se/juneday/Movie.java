package se.juneday;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Movie {
  
  public static class Details {

    private Map<String, String> details;

    public Details(Map<String, String> details) {
      this.details = details;
    }

    public boolean matchAny(Details details) {
      for(Map.Entry<String, String> detail : details.details.entrySet()) {
        if( detail.getValue()
            .equals(this.details.get(detail.getKey())) ){
          return true;
        }
      }
      return false;
    }

    private String getDetail(String detail) {
      return details.get(detail);
    }
    
    public boolean matchAll(Details details) {
      for(Map.Entry<String, String> detail : details.details.entrySet()) {
        if(!detail.getValue()
           .equals(this.details.get(detail.getKey())) ){
          return false;
        }
      }
      return true;
    }

    @Override
    public String toString() {
      return details.toString();
    }
  }

  public interface Matcher {
    public boolean matches(Movie movie);
  }
  
  private String imdbID;
  private Details details;
  public Movie(String imdbID, Details details) {
    this.imdbID = imdbID;
    this.details = details;
  }

  public String imdbID() {
    return imdbID;
  }
  
  public String getDetail(String detail) {
    return details.getDetail(detail);
  }

  public Details details() {
    return details;
  }
  
  @Override
  public String toString() {
    return "IMDB ID: " + imdbID + " "
      + details;
  }
  
}
