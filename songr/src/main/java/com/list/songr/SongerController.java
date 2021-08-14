package com.list.songr;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class SongerController {
    @Autowired
    AlbumRepository albumRepository;
    @GetMapping("/bbb")
    public String home(){
        return "home.html";
    }
   @GetMapping("/albums")
    public String getAlbums(Model model){
//       ArrayList<Album>list=new ArrayList<Album>();
       Album album1=new Album("The Bitter Truth","Evanescence",12,2839,"https://upload.wikimedia.org/wikipedia/en/thumb/7/7e/EvanescenceTheBitterTruth.png/220px-EvanescenceTheBitterTruth.png");
       Album album2=new Album("Hateer Min Tany","Hamza Namira",10,1000,"https://m.media-amazon.com/images/I/91CIYGh4WTL._SS500_.jpg");
       Album album3=new Album("Ana Kiteer","Sherine",12,3030,"https://upload.wikimedia.org/wikipedia/en/thumb/e/e2/Ana_Kiteer.jpg/220px-Ana_Kiteer.jpg");
//       albumRepository.save(album1);
//       albumRepository.save(album2);
//       albumRepository.save(album3);
//       list.add(album1);
//       list.add(album2);
//       list.add(album3);
        model.addAttribute("songs",albumRepository.findAll());
        return "albums.html";
   }

    @RequestMapping("/addAlbum")
    @PostMapping("/addAlbum")
    public RedirectView addAlbum(String title,String artist,int songCount,int length,String imageUrl){
        Album album=new Album(title,artist,songCount,length,imageUrl);
    albumRepository.save(album);
        return new RedirectView("/albums");
   }



}
