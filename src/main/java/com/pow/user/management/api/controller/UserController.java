package com.pow.user.management.api.controller;

import com.pow.user.management.api.dto.UserReqDto;
import com.pow.user.management.api.dto.UserResDto;
import com.pow.user.management.api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResDto> createUser(@Valid @RequestBody UserReqDto userReqDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(userReqDto));

    }

    @GetMapping
    public ResponseEntity<Page<UserResDto>> getUsers(@RequestParam(defaultValue = "0") int pageNo,
                                                     @RequestParam(defaultValue = "10") int pageSize,
                                                     @RequestParam(defaultValue = "ASC") String sortDir,
                                                     @RequestParam(defaultValue = "email") String sortField){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getUsers(pageNo, pageSize, sortDir, sortField));
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResDto> getUserByEmail(@PathVariable(name = "email") String email){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getUserByEmail(email));
    }
}
