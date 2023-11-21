package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping(path="/demo") 
public class ControleurPrincipal {
  @Autowired 
  private UserRepo userRepository;

  @PostMapping("/add")
  public @ResponseBody String addNewUser (@RequestBody CreerUtilisateurCommande request) {
    User utilisateur = new User(); 
    utilisateur.setNom(request.getNom());
    utilisateur.setEmail(request.getEmail());
    userRepository.save(utilisateur);
    return "Utilisateur enregistré dans la base de données !";
  }


  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}
