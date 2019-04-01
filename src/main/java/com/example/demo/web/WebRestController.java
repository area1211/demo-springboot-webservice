package com.example.demo.web;

import com.example.demo.domain.keword.KeywordRepository;
import com.example.demo.dto.keyword.KeywordSaveRequestDto;
import com.example.demo.domain.PostsRepository;
import com.example.demo.domain.PostsSaveRequestDto;
import com.example.demo.service.KeywordService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController // @ResponseBody를 모든 메소드에서 적용해줍니다.
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;
    private KeywordRepository keywordRepository;

    private KeywordService keywordService;

    private Environment env;


    @GetMapping("/profile")
    public String getProfile () {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }

    @PostMapping("/keyword")
    public Long saveKeyword(@RequestBody KeywordSaveRequestDto dto){
        return keywordService.save(dto);
    }
}
