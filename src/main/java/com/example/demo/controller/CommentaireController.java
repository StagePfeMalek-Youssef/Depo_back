package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.message.request.CommetaireRequest;
import com.example.demo.message.request.Mail;
import com.example.demo.model.Commentaire;
import com.example.demo.model.Sujet;
import com.example.demo.model.User;
import com.example.demo.repository.CommentaireRepo;
import com.example.demo.repository.SujetRepository;
import com.example.demo.security.service.EmailService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Api/Commentaire")
public class CommentaireController {
	@Autowired
private SujetRepository sujetRepo;
	@Autowired 
private CommentaireRepo commentaireRepo;
	@Autowired
	EmailService emailService;
	@GetMapping(path = "")
	 public List<Commentaire> index() { return commentaireRepo.findAllByOrderByUpdatedAtDesc(); }
	
	 @GetMapping(path = "/{id}")
	 public ResponseEntity<Commentaire> show(@PathVariable(value = "id")Long id) {
	     Optional<Commentaire> commentaire = commentaireRepo.findById(id);
	     return commentaire
	             .map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
	             .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	 }
	 
	 @PostMapping()
	 public Commentaire create(@RequestParam String titreSujet,@RequestParam String message) {
		   Commentaire commentaire=new Commentaire();
			commentaire.setTitresujet(titreSujet);
			Sujet sujet=sujetRepo.findByTitreSujet(titreSujet);	
			commentaire.setSujet(sujet);
			commentaire.setMessage(message);		
			commentaire.setCreatedAt(new Date());
			commentaire.setUpdatedAt(null);	
			ArrayList<String> mauvaumot = new ArrayList<String>();
			 mauvaumot.add("voleur");
			    mauvaumot.add("panne");
			    for (int i = 0; i < mauvaumot.size(); i++) {
			    	if (message.contains(mauvaumot.get(i))) {
			    		Mail mail=new Mail("youssefchouchene09@gmail.com",message);
			    		commentaire.setMessage(message);
			    		emailService.sendMailComment(mail);
			    			
					}else {
						
					}
			    }
	        
			
			commentaireRepo.save(commentaire);
	    
	     return commentaire;
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<Commentaire> update(@RequestParam String titreSujet,@RequestParam String message, @PathVariable(value = "id")Long id) {
	     Optional<Commentaire> commentaire = commentaireRepo.findById(id);
	     if (commentaire.isPresent()) {
	    	 commentaire.get().setMessage(message);
	    	 commentaire.get().setTitresujet(titreSujet);
	    	 commentaire.get().setUpdatedAt(new Date());
	    	 commentaireRepo.save(commentaire.get());
	         return ResponseEntity.status(HttpStatus.OK).build();
	     }
	     return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	 }
	 
	 @DeleteMapping("{id}")
	 public ResponseEntity<Void> destroy(@PathVariable(value = "id") Long id) {
	     Optional<Commentaire>  commentaire= commentaireRepo.findById(id);
	     if (commentaire.isPresent()) {
	    	 commentaireRepo.deleteById(id);
	         return ResponseEntity.status(HttpStatus.OK).build();
	     }
	     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	 }
	 
	 
	

}
