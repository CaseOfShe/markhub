package com.study.mapstruct;

import com.study.base.dto.CollectDto;
import com.study.base.dto.UserDto;
import com.study.search.CollectDoc;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-17T17:29:07+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
@Component
public class CollectDocMapperImpl implements CollectDocMapper {

    @Override
    public CollectDto toDto(CollectDoc collectDoc) {
        if ( collectDoc == null ) {
            return null;
        }

        CollectDto collectDto = new CollectDto();

        collectDto.setUser( collectDocToUserDto( collectDoc ) );
        collectDto.setId( collectDoc.getId() );
        collectDto.setTitle( collectDoc.getTitle() );
        collectDto.setUrl( collectDoc.getUrl() );
        collectDto.setNote( collectDoc.getNote() );
        collectDto.setPersonal( collectDoc.getPersonal() );
        collectDto.setCollected( collectDoc.getCollected() );
        collectDto.setCreated( collectDoc.getCreated() );

        return collectDto;
    }

    protected UserDto collectDocToUserDto(CollectDoc collectDoc) {
        if ( collectDoc == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( collectDoc.getUserId() );
        userDto.setAvatar( collectDoc.getUserAvatar() );
        userDto.setUsername( collectDoc.getUsername() );

        return userDto;
    }
}
