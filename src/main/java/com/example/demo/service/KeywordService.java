package com.example.demo.service;

import com.example.demo.domain.keword.Keyword;
import com.example.demo.domain.keword.KeywordRepository;
import com.example.demo.domain.keywordUrl.KeywordUrl;
import com.example.demo.dto.keyword.KeywordSaveRequestDto;
import com.example.demo.dto.keyword.KeywordMainResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class KeywordService {
    private KeywordRepository keywordRepository;

    @Transactional
    public Long save(KeywordSaveRequestDto dto) {

        if (findAllDesc().size() >= 5) return null;

        try {
            return keywordRepository.save(dto.toEntity()).getId();
        } catch (DataIntegrityViolationException e) {
            log.error(">>>>>>>>> history already exist...");
        }

        return null;
    }

    @Transactional(readOnly = true)
    // 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선되기 때문에 특별히 등록/수정/삭제 기능이 없는 메소드에선 사용하시는걸 추천드립니다.
    public List<KeywordMainResponseDto> findAllDesc() {
        return keywordRepository.findAllDesc()
                .map(KeywordMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    // 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선되기 때문에 특별히 등록/수정/삭제 기능이 없는 메소드에선 사용하시는걸 추천드립니다.
    public Optional<KeywordMainResponseDto> findKeyword(Long id) {
//        Keyword keyword = keywordRepository.findKeywordById(id);
        Optional<Keyword> byId = keywordRepository.findById(id);

        if (byId.isPresent())
            return Optional.of(new KeywordMainResponseDto(byId.get()));
        else
            return Optional.empty();
    }
}