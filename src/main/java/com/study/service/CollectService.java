package com.study.service;

import com.study.base.dto.CollectDto;
import com.study.base.dto.DatelineDto;
import com.study.entity.Collect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CollectService {

	List<DatelineDto> getDatelineByUserId(long userId);

	Page<CollectDto> findUserCollects(long userId, String dateline, Pageable pageable);

	Collect findById(long id);

	void deleteById(long id);

	void save(Collect collect);

	Page<CollectDto> findSquareCollects(Pageable pageable);
}
