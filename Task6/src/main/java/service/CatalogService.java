package service;

import empty.Album;
import empty.Group;
import empty.Song;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatalogService {
    private Map<Integer, Group> groupMap = new HashMap<>();


    public List<Group> getAllGroups(){
        List<Group> groupList = new ArrayList<>();
        for(int id: groupMap.keySet()){
            groupList.add(groupMap.get(id));
        }
        return groupList;
    }

    public Group getGroup(int id){
        return groupMap.get(id);
    }

    public Group addGroup(Group group){
        groupMap.put(group.getId(), group);
        return group;
    }

    public void delGroup(int id){
        groupMap.remove(id);
    }

    public Album getAlbum(int groupId, int albumId){
        Group group = groupMap.get(groupId);
        if (group != null) {
            List<Album> albumList = group.getAlbumList();
            for(Album album: albumList){
                if(album.getId() == albumId){
                    return album;
                }
            }
            return null;
        }
        return null;
    }

    public Album addAlbum(int groupId, Album album){
        Group group = groupMap.get(groupId);
        if (group != null) {
            group.getAlbumList().add(album);
            return album;
        }
        return null;
    }

    public void delAlbum(int groupId, int albumId){
        Group group = groupMap.get(groupId);
        if (group != null) {
            int c = 0;
            for(Album album:group.getAlbumList()){
                if (album.getId() != albumId){
                    c++;
                }
                else break;
            }
            group.getAlbumList().remove(c);
        }
    }

    public Song getSong(int groupId, int albumId, int songId){
        Album album = getAlbum(groupId, albumId);
        if (album != null){
            List<Song> songList = album.getSongList();
            for(Song song: songList){
                if(song.getId() == songId){
                    return song;
                }
            }
            return null;
        }
        return null;
    }

    public Song addSong(int groupId, int albumId, Song song){
        Album album = getAlbum(groupId, albumId);
        if (album != null){
            album.getSongList().add(song);
            return song;
        }
        return null;
    }

    public void delSong(int groupId, int albumId, int songId){
        Album album = getAlbum(groupId, albumId);
        if (album != null){
            int c = 0;
            for(Song song: album.getSongList()){
                if (song.getId() != songId){
                    c++;
                }
                else break;
            }
            album.getSongList().remove(c);
        }
    }


}
