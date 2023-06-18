package empty;

import java.util.List;

public class Group {
    private int id;
    private String name;
    private List<Album> albumList;

    public Group(int id, String name, List<Album> albumList) {
        this.id = id;
        this.name = name;
        this.albumList = albumList;
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

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }
}
