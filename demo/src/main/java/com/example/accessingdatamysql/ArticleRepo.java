package com.example.accessingdatamysql;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepo extends JpaRepository<Article, Integer> {
    Iterable<Article> findByAuthor(String id);
}