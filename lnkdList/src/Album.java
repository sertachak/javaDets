import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public void setSongList(ArrayList<Song> songList) {
        this.songList = songList;
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            this.songList.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        return songList.stream().filter( song -> song.getTitle().equals(title)).findAny().orElse(null);
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber -1;
        if(index >= 0 && (index <= this.songList.size())){
            playList.add(this.songList.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + "is not in this album");
        return false;
    }
}
