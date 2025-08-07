package springboot.springmvc.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/view")
    public String view(Model model){
        model.addAttribute()
        
        // nombre de la plantilla view.html
        return "view";
    }
}
