package com.example.demo.service;

import com.example.demo.domain.keword.Keyword;
import com.example.demo.domain.keword.KeywordRepository;
import com.example.demo.dto.keyword.KeywordSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KeywordServiceTest {

    @Autowired
    private KeywordService keywordService;

    @Autowired
    private KeywordRepository keywordRepository;

    @After
    public void cleanup () {
        keywordRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다 () {
        //given
        KeywordSaveRequestDto dto = KeywordSaveRequestDto.builder()
                .name("양지원")
                .build();

        //when
        keywordService.save(dto);

        //then
        Keyword posts = keywordRepository.findAll().get(0);
        assertThat(posts.getName()).isEqualTo(dto.getName());
    }
}