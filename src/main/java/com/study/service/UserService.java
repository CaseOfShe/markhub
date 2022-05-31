package com.study.service;

import com.study.base.dto.UserDto;

public interface UserService {
	UserDto register(String openid);

	UserDto getDtoById(Long userId);
}
