package com.example.demo.web;

import com.example.demo.service.KeywordService;
import com.example.demo.service.KeywordUrlService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class WebController {

    private KeywordService keywordService;
    private KeywordUrlService keywordUrlService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("keyword", keywordService.findAllDesc());
        return "main";
    }

    @GetMapping("/keyword/{keywordId}")
    public String keywordMain(Model model, @PathVariable Long keywordId) {
        model.addAttribute("keyword", keywordService.findKeyword(keywordId));
        model.addAttribute("keywordUrl", keywordUrlService.findTop10ByKeywordIdOrderByCreatedDateDesc(keywordId));

        return "keyword";
    }
}