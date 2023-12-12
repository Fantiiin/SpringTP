package com.example.accessingdatamysql;

public class ModifierArticleCommande {
    private String title;
    private String author;
    private String date;

    public ModifierArticleCommande(String title, String author, String date){
        this.title = title;
        this.author = author;
        this.date = date;
    }

    public ModifierArticleCommande(){
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

}