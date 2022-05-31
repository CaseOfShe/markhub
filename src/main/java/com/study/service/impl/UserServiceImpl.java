package com.study.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.study.base.dto.UserDto;
import com.study.entity.User;
import com.study.mapstruct.UserMapper;
import com.study.repository.UserRepository;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserMapper userMapper;

	@Override
	public UserDto register(String openid) {

		Assert.isTrue(openid != null, "不合法注册条件");

		User user = userRepository.findByOpenId(openid);

		if (user == null) {
			user = new User();
			user.setUsername("Hub-" + RandomUtil.randomString(5));
			user.setAvatar("https://s3.bmp.ovh/imgs/2022/04/17/48da6921a45048e8.jpg");

			user.setCreated(LocalDateTime.now());
			user.setOpenId(openid);

		} else {
			user.setLasted(LocalDateTime.now());
		}

		userRepository.save(user);
		return userMapper.toDto(user);
	}

	@Override
	public UserDto getDtoById(Long userId) {
		Optional<User> optional = userRepository.findById(userId);
		if (optional.isPresent()) {
			return userMapper.toDto(optional.get());
		}
		return null;
	}
}
