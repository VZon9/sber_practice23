package empty;

import java.util.List;

public class Album {
    private int id;
    private String name;
    private int year;
    private List<Song> songList;

    public Album(int id, String name, int year, List<Song> songList) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.songList = songList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
