package ru.chepikov.itrum.springmvcpageable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.chepikov.itrum.springmvcpageable.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long>, PagingAndSortingRepository<Book, Long> {
}
