package com.music.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAll(Pageable pageable);

    T save(T t);

    void delete(Long id);

    Optional<T> getById(Long id);

}
