package com.example.demo.dto.keywordUrl;

import com.example.demo.domain.keword.Keyword;
import com.example.demo.domain.keywordUrl.KeywordUrl;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class KeywordUrlMainResponseDto {
    private Long id;
    private Long keywordId;
    private String url;
    private String createdDate;
    private String modifiedDate;

    public KeywordUrlMainResponseDto(KeywordUrl entity) {
        id = entity.getId();
        keywordId = entity.getKeywordId();
        url = entity.getUrl();
        createdDate = toStringDateTime(entity.getCreatedDate());
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

    /**
     * Java 7 버전
     */
    private String toStringDateTimeByJava7(LocalDateTime localDateTime){
        if(localDateTime == null){
            return "";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }
}