package com.pow.user.management.api.service;

import com.pow.user.management.api.dto.UserReqDto;
import com.pow.user.management.api.dto.UserResDto;
import org.springframework.data.domain.Page;

public interface UserService {

    UserResDto createUser(UserReqDto userReqDto);

    Page<UserResDto> getUsers(int pageNo, int pageSize, String sortDir, String sortField);

    UserResDto getUserByEmail(String email);
}
