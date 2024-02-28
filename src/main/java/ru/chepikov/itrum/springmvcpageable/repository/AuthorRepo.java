package ru.chepikov.itrum.springmvcpageable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.chepikov.itrum.springmvcpageable.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Long>, PagingAndSortingRepository<Author, Long> {
}
