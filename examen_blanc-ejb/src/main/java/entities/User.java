package entities;

import java.io.Serializable;
import java.lang.String;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@ManagedBean
@SessionScoped
public class User implements Serializable {

	public enum Role{ CHEF_DEPARTEMENT, ADMINISTRATEUR, INGENIEUR, TECHNICIEN }
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="EMPL_ID")
	private int id;
	public User(String nom, String prenom, String adressmail, String password, Boolean isActif, Role role) {
		super();

		this.nom = nom;
		this.prenom = prenom;
		this.adressmail = adressmail;
		this.password = password;
		this.isActif = isActif;
		this.role = role;
	}
	
	public User(int id, String nom, String prenom, String adressmail, String password, Boolean isActif, Role role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adressmail = adressmail;
		this.password = password;
		this.isActif = isActif;
		this.role = role;
	}

	public Boolean getIsActif() {
		return isActif;
	}
	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name="EMPL_NAME")
	private String nom;
	@Column(name="EMPL_PNAME")
	private String prenom;
	@Column(name="EMPL_MAIL")
	private String adressmail;
	private String password;
	private Boolean isActif; 
	@Enumerated(EnumType.STRING)
	private Role role;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public String getAdressmail() {
		return this.adressmail;
	}

	public void setAdressmail(String adressmail) {
		this.adressmail = adressmail;
	}
   
}
