package app.controllers;

import app.dto.Album;
import app.dto.Group;
import app.dto.Song;
import app.repository.AlbumRepository;
import app.repository.GroupRepository;
import app.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MusicController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/home")
    public String getAllGroups(Model model){
        model.addAttribute("groups", groupRepository.findAll());
        model.addAttribute("group", new Group());
        return "home";
    }

    @PostMapping("/group")
    public String addGroup(@ModelAttribute Group group) {
        groupRepository.save(group);
        return "redirect:/home";
    }

    @PostMapping("/group/del")
    public String delGroup(@ModelAttribute Group group){
        groupRepository.deleteById(group.getId());
        return "redirect:/home";
    }

    @GetMapping("/group/{groupId}")
    public String getGroup(@PathVariable long groupId, Model model){
        model.addAttribute("albums", albumRepository.findByGroupId(groupId));
        model.addAttribute("group", groupRepository.findById(groupId).get());
        model.addAttribute("album", new Album());
        return "group";
    }

    @PostMapping("/group/{groupId}/album")
    public String addAlbum(@PathVariable long groupId, @ModelAttribute Album album) {
        album.setGroupId(groupId);
        albumRepository.save(album);
        return "redirect:/group/" + groupId;
    }

    @PostMapping("/group/{groupId}/album/del")
    public String delAlbum(@PathVariable long groupId, @ModelAttribute Album album){
        albumRepository.deleteById(album.getId());
        return "redirect:/group/" + groupId;
    }

    @GetMapping("/group/{groupId}/album/{albumId}")
    public String getAlbum(@PathVariable long groupId, @PathVariable long albumId, Model model){
        model.addAttribute("songs", songRepository.findByGroupIdAndAlbumId(groupId, albumId));
        model.addAttribute("group", groupRepository.findById(groupId).get());
        model.addAttribute("album", albumRepository.findByGroupIdAndId(groupId, albumId));
        model.addAttribute("song", new Song());
        return "album";
    }

    @PostMapping("/group/{groupId}/album/{albumId}/song")
    public String addSong(@PathVariable long groupId, @PathVariable long albumId, @ModelAttribute Song song) {
        song.setGroupId(groupId);
        song.setAlbumId(albumId);
        songRepository.save(song);
        return "redirect:/group/" + groupId + "/album/" + albumId;
    }

    @PostMapping("/group/{groupId}/album/{albumId}/song/del")
    public String delSong(@PathVariable long groupId, @PathVariable long albumId, @ModelAttribute Song song) {
        songRepository.deleteById(song.getId());
        return "redirect:/group/" + groupId + "/album/" + albumId;
    }

    @GetMapping("/group/{groupId}/album/{albumId}/song/{songId}")
    public String getSong(@PathVariable long groupId, @PathVariable long albumId, @PathVariable long songId, Model model) {
        model.addAttribute("song", songRepository.findByGroupIdAndAlbumIdAndId(groupId, albumId, songId));
        return "song";
    }

}
