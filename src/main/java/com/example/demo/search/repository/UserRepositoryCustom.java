package com.example.demo.search.repository;

import com.example.demo.search.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepositoryCustom {
    Page<UserDTO> searchUsers(String keyword, Pageable pageable);
}
