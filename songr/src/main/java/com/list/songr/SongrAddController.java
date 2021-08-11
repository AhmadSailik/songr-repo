package com.list.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongrAddController {


    @Autowired
    SongrRepository songrRepository;
    @Autowired
    AlbumRepository albumRepository;
    @GetMapping("/addSongrs")
    public String getAlbums(Model model){
        Iterable iterable;

        model.addAttribute("songs",songrRepository.findAll());
        return "songr.html";
    }

    @RequestMapping("/addSongr")
    @PostMapping("/addSongr")
    public RedirectView addSong(String title, int length, int trackNumber,Integer albumNum, Model model){
        Album albumSonger=albumRepository.findById(albumNum).get();
        String albumName=albumSonger.getTitle();
        Songr songr=new Songr(title,length,trackNumber,albumName,albumSonger);
        songrRepository.save(songr);

//        model.addAttribute("songrShow",songrRepository.findAll());
        return new RedirectView("/addSongrs");
    }
}

