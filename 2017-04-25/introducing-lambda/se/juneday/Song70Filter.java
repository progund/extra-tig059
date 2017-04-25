package se.juneday;

public class Song70Filter implements SongFilter {

  @Override
  public boolean keep(Song s) {
    return ( s.year() >= 1970 && s.year() <= 1979 );
  }
  
}
