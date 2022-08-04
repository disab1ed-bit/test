package com.example.testcase.library.repositories.impl;

import com.example.testcase.library.model.Book;
import com.example.testcase.library.repositories.CustomBookRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
class CustomBookRepositoryImpl implements CustomBookRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> findBooks(String query) {
        final String q = '%' + query + '%';

        return entityManager.createQuery("SELECT book from Book book where book.name like ?1", Book.class)
                .setParameter(1, q)
                .getResultList();
    }
}
