package com.example.demo.search.repository;

import com.example.demo.search.dto.UserDTO;
import com.example.demo.search.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByNameContaining(@Param("keyword") String keyword, Pageable pageable);

    Optional<User> findById(Long id);

    User save(User user);

    List<User> getUserByAge(@Param("age") int age);
}
