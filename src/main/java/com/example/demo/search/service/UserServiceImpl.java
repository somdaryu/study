package com.example.demo.search.service;

import com.example.demo.search.dto.UserDTO;
import com.example.demo.search.entity.User;
import com.example.demo.search.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<UserDTO> findByNameContaining(String keyword, Pageable pageable) {
        Page<User> user = userRepository.findByNameContaining(keyword, pageable);
        List<UserDTO> dtoList = user.getContent().stream().map(User::toDTO).toList();
        return  new PageImpl<>(dtoList, pageable, user.getTotalElements());
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null) {
            return null;
        }
        UserDTO dto = user.toDTO();
        return dto;
    }

    @Override
    @Transactional
    public UserDTO update(UserDTO userDTO) {
        // 1. 기존 유저 찾기
        Optional<User> optionalUser = userRepository.findById(userDTO.getId());

        if (optionalUser.isEmpty()) {
            return null; // 또는 throw new EntityNotFoundException("User not found")
        }

        // 2. 엔티티 꺼내서 값 덮어쓰기
        User user = optionalUser.get();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        // 3. 변경된 유저를 DTO로 변환해 반환
        return user.toDTO();
    }

    @Override
    public List<UserDTO> getUserByAge(int age) {
        List<UserDTO> dtoList = userRepository.getUserByAge(age).stream()
                .map(User::toDTO).toList();

        if(dtoList.isEmpty()) {
            return null;
        }
        return dtoList;
    }

    @Override
    public Page<UserDTO> searchUsers(String keyword, Pageable pageable) {
        return userRepository.searchUsers(keyword, pageable);
    }
}
