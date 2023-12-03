package com.example.booklibrary.repository;

import com.example.booklibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("select b from Book b where b.bookName like :name% ")
    List<Book> findByName(@Param("name") String name);
}
