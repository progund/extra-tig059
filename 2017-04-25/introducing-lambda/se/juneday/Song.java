package se.juneday;

public class Song {

  private String artist ;
  private String album ;
  private String title ;
  private int year; ;

  public Song(String artist, String album, String title, int year) {
    this.artist = artist;
    this.album = album;
    this.title = title;
    this.year = year;
  }
  
  public String artist() {
    return artist;
  }
  
  public String album() {
    return album;
  }
  
  public String title() {
    return title;
  }
  
  public int year() {
    return year;
  }
  
  @Override
  public String toString() {
    return " { " +  artist + " | " + album + " | " + title + " | " + year + " } ";
  }
  
}
