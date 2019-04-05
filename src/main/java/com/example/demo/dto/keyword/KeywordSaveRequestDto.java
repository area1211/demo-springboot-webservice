package com.example.demo.dto.keyword;

import com.example.demo.domain.keword.Keyword;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class KeywordSaveRequestDto {

    private String name;
//    private LocalDateTime modifiedDate;

    @Builder
    public KeywordSaveRequestDto(String name) {

        this.name = name;
//        this.modifiedDate = null;
    }


    public Keyword toEntity(){
        return Keyword.builder()
                .name(name)
                .build();
    }
}