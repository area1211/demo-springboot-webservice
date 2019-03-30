package com.example.demo.web;

import com.example.demo.service.KeywordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private KeywordService keywordService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("keyword", keywordService.findAllDesc());
        return "main";
    }
}