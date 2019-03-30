package com.example.demo.dto.keyword;

import com.example.demo.domain.keword.Keyword;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KeywordSaveRequestDto {

    private String name;

    @Builder
    public KeywordSaveRequestDto(String name) {
        this.name = name;
    }


    public Keyword toEntity(){
        return Keyword.builder()
                .name(name)
                .build();
    }
}