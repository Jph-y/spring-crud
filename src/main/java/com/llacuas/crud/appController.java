
package com.llacuas.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class appController {
    
    @GetMapping("")
    public String verPaginaInicioa(){
        return "index";
    }
}
