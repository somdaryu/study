package com.example.demo.paging.service;

import com.example.demo.basic.dto.BookDTO;
import com.example.demo.basic.entity.Book;
import com.example.demo.basic.repository.BookRepository;
import com.example.demo.basic.service.BookService;
import com.example.demo.paging.dto.PagingDTO;
import com.example.demo.paging.entity.Paging;
import com.example.demo.paging.repository.PagingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagingServiceImpl implements PagingService {

    private final PagingRepository pagingRepository;

    public PagingServiceImpl(PagingRepository pagingRepository) {
        this.pagingRepository = pagingRepository;
    }

    @Override
    public Paging saveBook(PagingDTO paging) {
        Paging entity = paging.toEntity();
        return pagingRepository.save(entity);
    }

    @Override
    public Page<PagingDTO> getAllBooks(Pageable pageable) {
        Page<Paging> pagingPage = pagingRepository.findAll(pageable);
        return pagingPage.map(Paging::toDTO);
    }

    @Override
    public PagingDTO getBookById(Long id) {
        return pagingRepository.findById(id).map(Paging::toDTO).orElse(null);
    }

    @Override
    public void updateBook(Long id, PagingDTO updatedPaging) {
        PagingDTO dto = pagingRepository.findById(id).map(Paging::toDTO).orElse(null);
        if(dto != null){
            dto.setTitle(updatedPaging.getTitle());
            dto.setAuthor(updatedPaging.getAuthor());
            dto.setPrice(updatedPaging.getPrice());
            dto.setPublishedDate(updatedPaging.getPublishedDate());
            pagingRepository.save(dto.toEntity());
        }
    }

    @Override
    public void deleteBook(Long id) {
        PagingDTO dto = pagingRepository.findById(id).map(Paging::toDTO).orElse(null);
        if(dto != null){
            pagingRepository.deleteById(id);
        }
    }

}
