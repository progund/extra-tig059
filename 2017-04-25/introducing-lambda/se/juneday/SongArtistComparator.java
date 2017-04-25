package se.juneday;

import java.util.Comparator;

public class SongArtistComparator implements Comparator<Song> {

  // Singleton version
  private static SongArtistComparator instance;
  static {
    instance = new SongArtistComparator();
  }
  public static SongArtistComparator getInstance() {
    return instance;
  }
  
  @Override
  public int compare(Song a, Song b) {
    return a.artist().compareTo(b.artist());
  }
    
}
