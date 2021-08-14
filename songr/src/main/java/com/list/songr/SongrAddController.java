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
    @GetMapping("/")
    public String getAlbums(Model model){
        model.addAttribute("songs",songrRepository.findAll());
        model.addAttribute("select",songrRepository.findAll());
        return "songr.html";
    }
    @RequestMapping("/filterSong")
    @GetMapping("/filterSong")
    public String showAlbums(Model model,int albumNum){
          if(albumNum==0){
              model.addAttribute("songs",songrRepository.findAll());
          }else {
              Iterable findAllByalbumSongerId=songrRepository.findAllByalbumSongerId(albumNum);
              model.addAttribute("songs",findAllByalbumSongerId);
          }
        model.addAttribute("select",songrRepository.findAll());

        return "songr.html";
    }

    @RequestMapping("/addSongr")
    @PostMapping("/addSongr")
    public RedirectView addSong(String title, int length, int trackNumber,int albumNum){
        Album albumSonger=albumRepository.findById(albumNum).get();
        String albumName=albumSonger.getTitle();
        Songr songr=new Songr(title,length,trackNumber,albumName,albumSonger);
        songrRepository.save(songr);
        return new RedirectView("/");
    }
}

