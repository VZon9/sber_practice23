package controllers;

import empty.Album;
import empty.Group;
import empty.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CatalogService;
import java.util.List;

@RestController
public class MusicController {

    @Autowired
    private CatalogService service;


    @GetMapping("/home")
    public List<Group> getAllGroups(){
        return service.getAllGroups();
    }

    @GetMapping("/group/{groupId}")
    public Group getGroup(@PathVariable int groupId){
        return service.getGroup(groupId);
    }

    @PostMapping("/group")
    public Group addGroup(@RequestBody Group group){
        return service.addGroup(group);
    }

    @DeleteMapping("/group/{groupId}")
    public void delGroup(@PathVariable int groupId){
        service.delGroup(groupId);
    }

    @GetMapping("/group/{groupId}/album/{albumId}")
    public Album getAlbum(@PathVariable int groupId, @PathVariable int albumId){
        return service.getAlbum(groupId, albumId);
    }

    @PostMapping("/group/{groupId}/album")
    public Album addAlbum(@PathVariable int groupId, @RequestBody Album album){
        return service.addAlbum(groupId, album);
    }

    @DeleteMapping("/group/{groupId}/album/{albumId}")
    public void delAlbum(@PathVariable int groupId, @PathVariable  int albumId){
        service.delAlbum(groupId, albumId);
    }

    @GetMapping("/group/{groupId}/album/{albumId}/song/{songId}")
    public Song getSong(@PathVariable int groupId, @PathVariable int albumId, @PathVariable int songId){
        return service.getSong(groupId, albumId, songId);
    }

    @PostMapping("/group/{groupId}/album/{albumId}/song")
    public Song addSong(@PathVariable int groupId, @PathVariable int albumId, @RequestBody Song song){
        return service.addSong(groupId, albumId, song);
    }

    @DeleteMapping("/group/{groupId}/album/{albumId}/song/{songId}")
    public void delSong(@PathVariable int groupId, @PathVariable int albumId, @PathVariable int songId){
        service.delSong(groupId, albumId, songId);
    }

}
