package com.example.demo.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Produit")
public class Produit {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)private long idPrd;
	    @Column(nullable= false, name="NumeroProduit")private int numPrd;
	    @Column(nullable= false, name="NomProduit")private String nomPrd;
	    @Column(nullable= false, name="categorie")private String categorie;
	    @Column(nullable= false)private String titre;
	    @Column(nullable= false, name="DescriptionCourte")private String descCourte;
	    @Column(nullable= false, name="DescriptionLong")private String descLong;
	    @Column(name = "created_at") @Temporal(TemporalType.TIMESTAMP) private Date createdAt = new Date();
	    @Column(name = "updated_at") @Temporal(TemporalType.TIMESTAMP) private Date updatedAt = new Date();
	    
	    @ManyToMany(fetch = FetchType.LAZY,
	    	      cascade = {
	    	          CascadeType.PERSIST,
	    	          CascadeType.MERGE
	    	      })
	    	  @JoinTable(name = "produit_user",
	    	        joinColumns = { @JoinColumn(name = "produit_id") },
	    	        inverseJoinColumns = { @JoinColumn(name = "user_id") })
	    	  private Set<User> users=new HashSet<>();

	    
		public Produit(int numPrd, String nomPrd, String categorie, String titre, String descCourte, String descLong,
				Date createdAt, Date updatedAt) {
			super();
			this.numPrd = numPrd;
			this.nomPrd = nomPrd;
			this.categorie = categorie;
			this.titre = titre;
			this.descCourte = descCourte;
			this.descLong = descLong;
			this.createdAt = new Date();
			this.updatedAt = new Date();
		}
		 
		public Produit(int numPrd, String nomPrd, String categorie, String titre, String descCourte, String descLong) {
			super();
			this.numPrd = numPrd;
			this.nomPrd = nomPrd;
			this.categorie = categorie;
			this.titre = titre;
			this.descCourte = descCourte;
			this.descLong = descLong;
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

		public Set<User> getUsers() {
			return users;
		}

		public void setUsers(Set<User> users) {
			this.users = users;
		}

		public Produit() {
	    }

	    public long getIdPrd() {
	        return idPrd;
	    }

	    public void setIdPrd(long idPrd) {
	        this.idPrd = idPrd;
	    }

	    public int getNumPrd() {
	        return numPrd;
	    }

	    public void setNumPrd(int numPrd) {
	        this.numPrd = numPrd;
	    }

	    public String getNomPrd() {
	        return nomPrd;
	    }

	    public void setNomPrd(String nomPrd) {
	        this.nomPrd = nomPrd;
	    }

	    public String getCategorie() {
	        return categorie;
	    }

	    public void setCategorie(String categorie) {
	        this.categorie = categorie;
	    }

	    public String getTitre() {
	        return titre;
	    }

	    public void setTitre(String titre) {
	        this.titre = titre;
	    }

	    public String getDescCourte() {
	        return descCourte;
	    }

	    public void setDescCourte(String descCourte) {
	        this.descCourte = descCourte;
	    }

	    public String getDescLong() {
	        return descLong;
	    }

	    public void setDescLong(String descLong) {
	        this.descLong = descLong;
	    }

	   	    


}
