package controllers;

import empty.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.CatalogService;

@Controller
public class MusicController {

    @Autowired
    private CatalogService service;

    @GetMapping("/home")
    public String getGroups(Model model){
        model.addAttribute("groups", service.getAllGroups());
        model.addAttribute("group", new Group());
        return "home";
    }

    @PostMapping("/group")
    public String createArtist(@ModelAttribute Group group) {
        service.addGroup(group);
        return "redirect:/home";
    }
}
