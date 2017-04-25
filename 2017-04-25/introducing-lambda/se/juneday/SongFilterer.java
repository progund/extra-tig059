package se.juneday;

import java.util.List;
import java.util.ArrayList;

public class SongFilterer {

  public static List<Song> filter70sNaive (List<Song> songs) {
    List<Song> songsToReturn =
      new ArrayList<>();
    for (Song s : songs) {
      if (s.year() >= 1970 && s.year() <= 1979 ) {
        songsToReturn.add(s);
      }
    }
    return songsToReturn;
  }
    
  public static List<Song> filterbyPeriod (List<Song> songs,
                                           int startYear,
                                           int stopYear) {
    List<Song> songsToReturn =
      new ArrayList<>();
    for (Song s : songs) {
      if (s.year() >= startYear && s.year() <= stopYear ) {
        songsToReturn.add(s);
      }
    }
    return songsToReturn;
  }

  public static List<Song> filter70s (List<Song> songs) {
    return filterbyPeriod (songs, 1970, 1979);
  }
  
  public static List<Song>filterSongs(List<Song> songs,
                                      SongFilter filter) {
    List<Song> songsToReturn =
      new ArrayList<>();

    for (Song s : songs) {
      if (filter.keep(s)) {
        songsToReturn.add(s);
      }
    }
    return songsToReturn;
  }

}
