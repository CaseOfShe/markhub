package com.study.service;

import com.study.base.dto.CollectDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchService {

	Page<CollectDto> search(String keyword, Long userId, Pageable pageable);
}
