package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping(path="") 
public class ControleurPrincipal {
  @Autowired 
  private ArticleRepo articleRepository;
  @Autowired
  private UserRepo userRepository;

  @PostMapping("/user/add")
  public @ResponseBody String addNewUser (@RequestBody CreerUtilisateurCommande request) {
    User utilisateur = new User(); 
    utilisateur.setUsername(request.getUsername());
    utilisateur.setPassword(request.getPassword());
    utilisateur.setRole(request.getRole());
    userRepository.save(utilisateur);
    return "Utilisateur enregistré dans la base de données !";
  }

  @PostMapping("/articles/add")
  public @ResponseBody String addNewArticle (@RequestBody CreerArticleCommande request) {
    Article article = new Article(); 
    article.setTitle(request.getTitle());
    article.setAuthor(request.getAuthor());
    article.setDate();
    articleRepository.save(article);
    return "Article enregistré dans la base de données !";
  }

  @GetMapping(path="/user/list")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
  
  @GetMapping(path="/articles/list")
  public @ResponseBody Iterable<Article> getAllArticles() {
    return articleRepository.findAll();
  }
}
