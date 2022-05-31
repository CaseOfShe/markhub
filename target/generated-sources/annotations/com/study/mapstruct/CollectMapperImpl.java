package com.study.mapstruct;

import com.study.base.dto.CollectDto;
import com.study.entity.Collect;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-17T17:29:07+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
@Component
public class CollectMapperImpl implements CollectMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public CollectDto toDto(Collect collect) {
        if ( collect == null ) {
            return null;
        }

        CollectDto collectDto = new CollectDto();

        collectDto.setId( collect.getId() );
        collectDto.setTitle( collect.getTitle() );
        collectDto.setUrl( collect.getUrl() );
        collectDto.setNote( collect.getNote() );
        collectDto.setUser( userMapper.toDto( collect.getUser() ) );
        collectDto.setPersonal( collect.getPersonal() );
        collectDto.setCollected( collect.getCollected() );
        collectDto.setCreated( collect.getCreated() );

        return collectDto;
    }

    @Override
    public List<CollectDto> toList(List<Collect> collects) {
        if ( collects == null ) {
            return null;
        }

        List<CollectDto> list = new ArrayList<CollectDto>( collects.size() );
        for ( Collect collect : collects ) {
            list.add( toDto( collect ) );
        }

        return list;
    }
}
