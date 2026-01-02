package com.pow.user.management.api.dto;

import com.pow.user.management.api.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity (UserReqDto userReqDto);
    UserResDto toResDto (User user);
}
