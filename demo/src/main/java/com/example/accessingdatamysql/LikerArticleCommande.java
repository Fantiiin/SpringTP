package com.example.accessingdatamysql;

public class LikerArticleCommande {
    private String author;
    private Integer idArticle;

    public LikerArticleCommande(String author, Integer idArticle){
        this.author = author;
        this.idArticle = idArticle;
    }

    public LikerArticleCommande(){
    }

    public Integer getId() {
        return idArticle;
    }

    public String getAuthor() {
        return author;
    }

}