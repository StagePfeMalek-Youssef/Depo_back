package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Sujet")
public class Sujet {
	    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(nullable = false, name = "Id_Sujet")private Long idSu;
	    @Column(nullable = false, name = "Titre_De_Sujet")private String titreSujet;
	    private String message;
	    @Column(name = "created_at") @Temporal(TemporalType.TIMESTAMP) private Date createdAt = new Date();
	    @Column(name = "updated_at") @Temporal(TemporalType.TIMESTAMP) private Date updatedAt = new Date();
	    @ManyToOne
	    @JoinColumn(name = "user_ID")@JsonIgnore private User userSujet;
	    
	    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sujet")
	    private List<Sujet> sujet ;
	    
	
		
		public Sujet(String titreSujet, String message, Date createdAt, Date updatedAt, User userSujet) {
			super();
			this.titreSujet = titreSujet;
			this.message = message;
			this.createdAt = new Date();
			this.updatedAt = new Date();
			this.userSujet = userSujet;
		}

		public Sujet() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getIdSu() {
			return idSu;
		}
		public void setIdSu(Long idSu) {
			this.idSu = idSu;
		}
		public String getTitreSujet() {
			return titreSujet;
		}
		public void setTitreSujet(String titreSujet) {
			this.titreSujet = titreSujet;
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
		public User getUser() {
			return userSujet;
		}
		public void setUser(User userSujet) {
			this.userSujet = userSujet;
		}
		
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}

		
	    

}
