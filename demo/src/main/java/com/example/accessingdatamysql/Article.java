package com.example.accessingdatamysql;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer idArticle;

  private String title;

  private String author;

  private String date;

  public Integer getIdArticle() {
    return idArticle;
  }

  public void setIdArticle(Integer idArticle) {
    this.idArticle = idArticle;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getDate() {
    return date;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setDate() {
    java.util.Date date = new java.util.Date();
    this.date = new Date(date.getTime()).toString();
  }
}