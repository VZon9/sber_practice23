package app.controllers;

import app.empty.Album;
import app.empty.Group;
import app.empty.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import app.service.CatalogService;

@Controller
public class MusicController {

    @Autowired
    private CatalogService service;

    @GetMapping("/home")
    public String getAllGroups(Model model){
        model.addAttribute("groups", service.getAllGroups());
        model.addAttribute("group", new Group());
        return "home";
    }

    @PostMapping("/group")
    public String addGroup(@ModelAttribute Group group) {
        service.addGroup(group);
        return "redirect:/home";
    }

    @GetMapping("/group/{groupId}")
    public String getGroup(@PathVariable int groupId, Model model){
        model.addAttribute("group", service.getGroup(groupId));
        model.addAttribute("album", new Album());
        return "group";
    }

    @PostMapping("/group/{groupId}/album")
    public String addAlbum(@PathVariable int groupId, @ModelAttribute Album album) {
        service.addAlbum(groupId, album);
        return "redirect:/group/" + groupId;
    }

    @GetMapping("/group/{groupId}/album/{albumId}")
    public String getAlbum(@PathVariable int groupId, @PathVariable int albumId, Model model){
        Group group = service.getGroup(groupId);
        Album album = service.getAlbum(groupId, albumId);
        Song song = new Song();
        model.addAttribute("group", group);
        model.addAttribute("album", album);
        model.addAttribute("song", song);
        return "album";
    }

    @PostMapping("/group/{groupId}/album/{albumId}/song")
    public String addSong(@PathVariable int groupId, @PathVariable int albumId, @ModelAttribute Song song) {
        service.addSong(groupId, albumId, song);
        return "redirect:/group/" + groupId + "/album/" + albumId;
    }

    @GetMapping("/group/{groupId}/album/{albumId}/song/{songId}")
    public String getSong(@PathVariable int groupId, @PathVariable int albumId, @PathVariable int songId, Model model) {
        Group group = service.getGroup(groupId);
        Album album = service.getAlbum(groupId, albumId);
        Song song = service.getSong(groupId, albumId, songId);
        model.addAttribute("group", group);
        model.addAttribute("album", album);
        model.addAttribute("song", song);
        return "song";
    }

}
