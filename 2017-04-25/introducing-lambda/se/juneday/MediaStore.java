package se.juneday;

import java.util.List;
import java.util.ArrayList;
//import java.util.Collections;

public class MediaStore {

  private static MediaStore instance;
  private List<Song> songs;

  static {
    instance = new MediaStore();
  }
  
  private  MediaStore() {
    songs = new ArrayList<>();
    songs.add(new Song("Pink Floyd",
                       "Animals",
                       "Dogs",
                       1977));
    songs.add(new Song("Pink Floyd",
                       "Animals",
                       "Sheep",
                       1977));
    songs.add(new Song("The The",
                       "Mind Bomb",
                       "Armageddon Days Are Here (Again)",
                       1989));
    songs.add(new Song("Primus",
                       "Sailing on the seas of cheese",
                       "Here Come the Bastards",
                       1991));
    songs.add(new Song("Primus",
                       "Frizzle Fry",
                       "John the fisherman",
                       1990));
    songs.add(new Song("Neil Young",
                       "Everybody knows this is nowhere",
                       "Everybody knows this is nowhere",
                       1969));
  }

  public static MediaStore getInstance() {
    return instance;
  }
  
  public List<Song> getMedia() {
    return songs;
  }
  
}

