package com.study.mapstruct;

import com.study.base.dto.CollectDto;
import com.study.search.CollectDoc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CollectDocMapper {

	@Mappings({
			@Mapping(source = "userId", target = "user.id"),
			@Mapping(source = "userAvatar", target = "user.avatar"),
			@Mapping(source = "username", target = "user.username"),
	})
    CollectDto toDto(CollectDoc collectDoc);

}
