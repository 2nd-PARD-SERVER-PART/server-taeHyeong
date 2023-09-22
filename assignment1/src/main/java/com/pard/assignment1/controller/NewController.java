package com.pard.assignment1.controller;

import com.pard.assignment1.dto.InfoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewController {
    @GetMapping("/")
    public String start() {
        return "start";
    }

    @PostMapping("/showInfo")
    public String showInfo(Model model, InfoDto infodto) {
        model.addAttribute("myInfo", infodto);
        return "showInfo";
    }

    @GetMapping("/submitInfo")
    public String submitInfo() {
        return"submitInfo";
    }
}
