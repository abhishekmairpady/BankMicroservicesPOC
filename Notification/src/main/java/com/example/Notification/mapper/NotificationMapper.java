package com.example.Notification.mapper;

import com.example.Notification.model.NotificationEntity;
import com.example.enroll_service.model.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NotificationMapper {

    NotificationMapper MAPPER= Mappers.getMapper(NotificationMapper.class);

    NotificationEntity covertToEntity(Notification notification);

    Notification convertToDto(NotificationEntity notification);
}
