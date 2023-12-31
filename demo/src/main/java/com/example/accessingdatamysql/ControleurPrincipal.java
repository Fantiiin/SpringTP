  package com.example.accessingdatamysql;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.PostMapping;
  import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(path="/user")
    public String redirectToUserList() {
      return "redirect:/user/list";
    }
    
    @GetMapping(path="/articles")
    public String redirectToArticleList() {
      return "redirect:/articles/list";
    }
    
    @GetMapping(path="/user/{id}")
    public @ResponseBody Iterable<Article> getArticlesByUser(@PathVariable("id") Integer userId) {
      String author = String.valueOf(userId);
      return articleRepository.findByAuthor(author);
    }
    
    @GetMapping(path="/articles/{id}")
    public @ResponseBody Article getArticleById(@PathVariable("id") Integer articleId) {
      return articleRepository.findById(articleId).orElse(null);
    }

    @PutMapping(path="/articles/modifier/{id}")
    public @ResponseBody String modifierArticle(@RequestBody ModifierArticleCommande request, @PathVariable("id") Integer articleId) {
      String title = request.getTitle();
      String author = request.getAuthor();
      Article article = articleRepository.findById(articleId).orElse(null);
      article.setTitle(title);
      article.setAuthor(author);
      articleRepository.save(article);
      return "Article modifié dans la base de données !";
    }

  @PutMapping(path="/articles/like/{id}")
  public @ResponseBody String likerArticle (@RequestBody LikerArticleCommande request, @PathVariable("id") String articleId) {
    String author = request.getAuthor();
    User utilisateur = userRepository.findById(author);
    Article article = articleRepository.findById(Integer.parseInt(articleId)).orElse(null);
    article.getLikes().add(utilisateur);
    articleRepository.save(article);
    return "Article liké dans la base de données !";
    }

  }
