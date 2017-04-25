package se.juneday;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class TestSort {

    public static void main(String[] args) {
      List<Song> songs = MediaStore.getInstance().getMedia();
        
      System.out.println("Songs unsorted");
      System.out.println(songs);
      System.out.println();
      
      /*
       * Sort using class implementing Comparator
       */ 
      //Collections.sort(songs, new SongArtistComparator());
      Collections.sort(songs, SongArtistComparator.getInstance());
      System.out.println("Songs sorted (artist):");
      System.out.println(songs);
      System.out.println();

      /*
       * Sort using class implementing Comparator, 
       * reverse using Collections
       */ 
      Collections.sort(songs,
                       Collections.reverseOrder(SongArtistComparator.getInstance()));
      System.out.println("Songs sorted (artist) and reversed:");
      System.out.println(songs);
      System.out.println();


      /*
       * Sort using anonymous inner class implementing Comparator
       */ 
      Collections.sort(songs, new Comparator<Song>() {
          @Override
          public int compare(Song a, Song b) {
            return a.album().compareTo(b.album());
          }
        });      
      System.out.println("Songs sorted (album):");
      System.out.println(songs);
      System.out.println();

      
      /*
       * Sort using lambda notation
       */ 
      Collections.sort(songs,
                         (a, b) -> { return a.title().compareTo(b.title()); });
      System.out.println("Songs sorted (song title):");
      System.out.println(songs);
      System.out.println();
      
      /*
       * Sort using lambda notation
       */ 
      Collections.sort(songs,
                       (a, b) -> { return a.year() - b.year(); });
      System.out.println("Songs sorted (year):");
      System.out.println(songs);
      System.out.println();
      
    }
}
