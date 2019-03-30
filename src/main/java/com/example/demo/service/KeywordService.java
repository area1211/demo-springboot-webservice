package com.example.demo.service;

import com.example.demo.domain.keword.KeywordRepository;
import com.example.demo.domain.KeywordSaveRequestDto;
import com.example.demo.dto.keyword.KeywordMainResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class KeywordService {
    private KeywordRepository keywordRepository;

    @Transactional
    public Long save(KeywordSaveRequestDto dto){
        return keywordRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true) // 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선되기 때문에 특별히 등록/수정/삭제 기능이 없는 메소드에선 사용하시는걸 추천드립니다.
    public List<KeywordMainResponseDto> findAllDesc() {
        return keywordRepository.findAllDesc()
                .map(KeywordMainResponseDto::new)
                .collect(Collectors.toList());
    }
}