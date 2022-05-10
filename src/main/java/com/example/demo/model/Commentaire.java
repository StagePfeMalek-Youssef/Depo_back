package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "Commentaire")
public class Commentaire {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(nullable = false, name = "Id_Commentaire")private Long id;
    @Column(name = "created_at") @Temporal(TemporalType.TIMESTAMP) private Date createdAt = new Date();
    @Column(name = "updated_at") @Temporal(TemporalType.TIMESTAMP) private Date updatedAt = new Date();
    private String message;
    private String titresujet;
    
    @ManyToOne
    @JoinColumn(name = "sujet_ID")@JsonIgnore private Sujet sujet;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sujet getSujet() {
		return sujet;
	}
	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getTitresujet() {
		return titresujet;
	}
	public void setTitresujet(String titresujet) {
		this.titresujet = titresujet;
	}
	public Commentaire(Date createdAt, Date updatedAt, String message, String titresujet, Sujet sujet) {
		super();
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.message = message;
		this.titresujet = titresujet;
		this.sujet = sujet;
	}
	
    
    
    

}
