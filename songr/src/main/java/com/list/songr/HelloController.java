package com.list.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
   public String start(){
       return "hello.html";
   }
    @GetMapping("/capitalize")
    public String capitalize(Model model, @RequestParam String word){
    Capitalize capitalize=new Capitalize(word);
    model.addAttribute("cap",capitalize);
    return "capitalize.html";
    }

}
