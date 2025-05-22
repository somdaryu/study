package com.example.demo.paging.repository;

import com.example.demo.paging.entity.Paging;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface PagingRepository extends JpaRepository<Paging, Long> {
    Page<Paging> findAll(Pageable pageable);
}
