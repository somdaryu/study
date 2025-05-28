package com.example.demo.search.controller;

import com.example.demo.search.dto.UserDTO;
import com.example.demo.search.entity.User;
import com.example.demo.search.repository.UserRepository;
import com.example.demo.search.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // # pageable은 자동으로 정렬해줘서 sort= 파라미터값으로 정렬설정할 수 있음
    @GetMapping("/list")
    public Page<UserDTO> findBykeyword(@RequestParam(name = "keyword") String keyword,
                                       @PageableDefault(size = 5) Pageable pageable) {
        return userService.searchUsers(keyword, pageable);
    }

    @GetMapping
    public UserDTO findById(@RequestParam("id") Long id) {
        return userService.findById(id);
    }

    // # 예외처리 @Valid
    @PostMapping("/update")
    public UserDTO update(@RequestBody @Valid UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @GetMapping("/age")
    public List<UserDTO> getUserByAge(@RequestParam("age") int age) {
        return userService.getUserByAge(age);
    }
}
