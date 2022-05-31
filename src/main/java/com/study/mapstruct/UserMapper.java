package com.study.mapstruct;

import com.study.base.dto.UserDto;
import com.study.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserDto toDto(User user);

}
