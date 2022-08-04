package com.example.testcase.library.repositories;

import com.example.testcase.library.model.Book;

import java.util.List;

public interface CustomBookRepository {
    List<Book> findBooks(String query);
}