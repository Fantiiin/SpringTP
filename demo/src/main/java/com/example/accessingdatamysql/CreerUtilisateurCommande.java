package com.example.accessingdatamysql;

public class CreerUtilisateurCommande {
    private String nom;
    private String email;

    public CreerUtilisateurCommande(String nom, String email){
        this.nom = nom;
        this.email = email;
    }

    public CreerUtilisateurCommande(){
        
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
