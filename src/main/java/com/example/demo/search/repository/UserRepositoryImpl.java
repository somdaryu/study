package com.example.demo.search.repository;

import com.example.demo.search.dto.UserDTO;
import com.example.demo.search.entity.QUser;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory queryFactory;


    @Override
    public Page<UserDTO> searchUsers(String keyword, Pageable pageable) {
        QUser user = QUser.user;

        List<UserDTO> result = queryFactory
                .select(Projections.constructor(UserDTO.class,
                        user.id,
                        user.name,
                        user.age))
                .from(user)
                .where(user.name.containsIgnoreCase(keyword))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .select(user.count())
                .from(user)
                .where(user.name.containsIgnoreCase(keyword))
                .fetchOne();

        return new PageImpl<>(result, pageable, total);
    }
}
