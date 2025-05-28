package com.example.demo.search.service;

import com.example.demo.search.dto.UserDTO;
import com.example.demo.search.entity.User;
import com.example.demo.search.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    Page<UserDTO> findByNameContaining(String keyword, Pageable pageable);

    UserDTO findById(Long id);

    UserDTO update(UserDTO userDTO);

    List<UserDTO> getUserByAge(int age);

    // # querydsl 사용
    Page<UserDTO> searchUsers(String keyword, Pageable pageable);
}
