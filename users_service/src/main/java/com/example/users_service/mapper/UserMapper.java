package com.example.users_service.mapper;

import com.example.users_service.dto.UserDto;
import com.example.users_service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper MAPPER= Mappers.getMapper(UserMapper.class);

    @Mappings({@Mapping(source = "fName",target = "firstName"),
            @Mapping(source = "lName",target = "lastName")})
    User covertToEntity(UserDto userDto);

    @Mappings({@Mapping(source = "firstName",target = "fName"),
            @Mapping(source = "lastName",target = "lName")})
    UserDto convertToDto(User user);
}
