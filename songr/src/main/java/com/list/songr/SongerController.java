package com.list.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class SongerController {
    @GetMapping("/")
    public String home(){
        return "home.html";
    }
   @GetMapping("/albums")
    public String getAlbums(Model model){
       ArrayList<Album>list=new ArrayList<Album>();
       Album album1=new Album("The Bitter Truth","Evanescence",12,2839,"https://upload.wikimedia.org/wikipedia/en/thumb/7/7e/EvanescenceTheBitterTruth.png/220px-EvanescenceTheBitterTruth.png");
       Album album2=new Album("Hateer Min Tany","Hamza Namira",10,1000,"https://m.media-amazon.com/images/I/91CIYGh4WTL._SS500_.jpg");
       Album album3=new Album("Ana Kiteer","Sherine",12,3030,"https://upload.wikimedia.org/wikipedia/en/thumb/e/e2/Ana_Kiteer.jpg/220px-Ana_Kiteer.jpg");
       list.add(album1);
       list.add(album2);
       list.add(album3);
        model.addAttribute("songs",list);
        return "albums.html";
   }
}
