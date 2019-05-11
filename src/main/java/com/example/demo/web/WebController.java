package com.example.demo.web;

import com.example.demo.dto.keyword.KeywordMainResponseDto;
import com.example.demo.service.KeywordService;
import com.example.demo.service.KeywordUrlService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class WebController {

    private KeywordService keywordService;
    private KeywordUrlService keywordUrlService;

    @GetMapping({"/", "/main"})
    public String main(Model model) {
        model.addAttribute("keyword", keywordService.findAllDesc());
        model.addAttribute("keywordLength", keywordService.findAllDesc().size());
        return "main";
    }

    @GetMapping("/keyword/{keywordId}")
    public String keywordMain(Model model, @PathVariable Long keywordId) {
        Optional<KeywordMainResponseDto> optKeyword = keywordService.findKeyword(keywordId);
        if(optKeyword.isPresent()) {
            model.addAttribute("keyword", optKeyword.get());
            model.addAttribute("keywordUrl", keywordUrlService.findTop10ByKeywordIdOrderByCreatedDateDesc(keywordId));
            return "keyword";
        }

        return "redirect:/main";
    }
}