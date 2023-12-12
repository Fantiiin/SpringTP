package com.example.accessingdatamysql;

public class ModifierArticleCommande {
    private String title;
    private String author;
    private Integer idArticle;

    public ModifierArticleCommande(String title, String author, Integer idArticle){
        this.title = title;
        this.author = author;
        this.idArticle = idArticle;
    }

    public ModifierArticleCommande(){
    }

    public Integer getId() {
        return idArticle;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}