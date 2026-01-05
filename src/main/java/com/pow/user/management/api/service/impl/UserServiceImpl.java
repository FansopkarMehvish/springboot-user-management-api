package com.pow.user.management.api.service.impl;

import com.pow.user.management.api.dto.UserMapper;
import com.pow.user.management.api.dto.UserReqDto;
import com.pow.user.management.api.dto.UserResDto;
import com.pow.user.management.api.exception.EmailAlreadyExistsException;
import com.pow.user.management.api.exception.ResourceNotFoundException;
import com.pow.user.management.api.model.User;
import com.pow.user.management.api.repository.UserRepository;
import com.pow.user.management.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResDto createUser(UserReqDto userReqDto) {
        if(userRepository.existsByEmail(userReqDto.getEmail())){
            throw new EmailAlreadyExistsException("Email already exists!");
        }

        User newUser = userMapper.toEntity(userReqDto);
        newUser.setPassword(passwordEncoder.encode(userReqDto.getPassword()));
        User savedUser = userRepository.save(newUser);
        return userMapper.toResDto(savedUser);
    }

    @Override
    public Page<UserResDto> getUsers(int pageNo, int pageSize, String sortDir, String sortField) {
        Sort sort = Sort.by(sortDir.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(userMapper::toResDto);
    }

    @Override
    public UserResDto getUserByEmail(String email) {
        return userMapper.toResDto(userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email)));
    }
}
