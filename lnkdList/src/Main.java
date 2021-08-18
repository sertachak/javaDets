import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    private static ArrayList<Album> albums =  new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Holy Man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Coko", 6.3);
        album.addSong("YasMama", 4.2);
        albums.add(album);

        album = new Album("For those about to Rock", "AC/DC");
        album.addSong("Lets go", 3.45);
        album.addSong("Inhect the venom", 3.33);
        album.addSong("C.O.D", 5.25);
        albums.add(album);


        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlayList("Coko", playlist);
        albums.get(0).addToPlayList("Speed King", playlist);
        albums.get(0).addToPlayList(1, playlist);
        albums.get(1).addToPlayList(1, playlist);

        play(playlist);
    }

    public static void play(LinkedList<Song> playList) {
        ListIterator<Song> iterator = playList.listIterator();
        if(playList.size() == 0 ) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now playing " + iterator.next().toString());
        }
    }
}
