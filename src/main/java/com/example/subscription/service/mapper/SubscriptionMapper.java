package com.example.subscription.service.mapper;

import com.example.subscription.api.dto.SubscriptionDto;
import com.example.subscription.persistence.entity.SubscriptionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionDto entityToDto(SubscriptionEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    SubscriptionEntity dtoToEntity(SubscriptionDto dto);
}
