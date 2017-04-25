package se.juneday;

import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Comparator;

public class TestFilter {
  
  public static void main(String[] args) {
    List<Song> songs = MediaStore.getInstance().getMedia();

    /*
     * Sort using lambda notation
     */ 
    Collections.sort(songs,
                     (a, b) -> { return a.year() - b.year(); });
    System.out.println("Songs sorted (year):");
    System.out.println(songs);
    System.out.println();

    /*
     * Filter 70's songs
     */
    System.out.println("Songs unfiltered");
    System.out.println(songs);
    System.out.println();      
    
    System.out.println("Songs filtered naively");
    System.out.println(SongFilterer.filter70sNaive(songs));
    System.out.println();      

    System.out.println("Songs filtered slightly smarter");
    System.out.println(SongFilterer.filterbyPeriod(songs, 1970, 1979));
    System.out.println();      

    System.out.println("Songs filtered using SongFilter");
    System.out.println(SongFilterer.filterSongs(songs,
                                                new Song70Filter()));
    System.out.println();      

    System.out.println("Songs filtered using anonymous 90's SongFilter");
    System.out.println(SongFilterer
                       .filterSongs(songs,
                                    new SongFilter() {
                                      @Override
                                      public boolean keep(Song s) {
                                        return (s.year() >= 1990 && s.year() <= 1999 );
                                      } }));
    System.out.println();      

    System.out.println("Songs filtered using anonymous \"songs beginning with 'A'\" SongFilter");
    System.out.println(SongFilterer
                       .filterSongs(songs,
                                    new SongFilter() {
                                      @Override
                                      public boolean keep(Song s) {
                                        return (s.title().toUpperCase().startsWith("A"));
                                      } }));
    System.out.println();      

    System.out.println("Songs filtered using lambda 80's SongFilter");
    System.out.println(SongFilterer
                       .filterSongs(songs,
                                    (s) -> { return (s.year() >= 1980 && s.year() <= 1989 ) ; } ));
    System.out.println();      

    System.out.println("Songs filtered using Stream 60's SongFilter");
    System.out.println(songs
                       .stream()
                       .filter( s -> (s.year() >= 1960) && (s.year() <= 1969) )
                       .collect(Collectors.toList()));
    System.out.println();      
  }
}
