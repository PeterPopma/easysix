package com.peterpopma.easysix.domain.mapper;

import com.peterpopma.easysix.domain.dto.DomainDto;
import com.peterpopma.easysix.domain.entity.Domain;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DomainMapper {

    DomainDto toDto(Domain domain);

    @Mapping(target = "version", ignore = true)
    Domain toEntity(DomainDto dto);

    List<DomainDto> toDtoList(List<Domain> domains);

    List<Domain> toEntityList(List<DomainDto> dtos);
}
