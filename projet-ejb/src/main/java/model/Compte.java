package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the compte database table.
 * 
 */
@Entity
@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcompte;

	private String email;

	private String motdepasse;

	private String pseudo;

	//bi-directional many-to-one association to DemandeAmi
	@OneToMany(mappedBy="compte1")
	private List<DemandeAmi> demandeAmis1;

	//bi-directional many-to-one association to DemandeAmi
	@OneToMany(mappedBy="compte2")
	private List<DemandeAmi> demandeAmis2;

	//bi-directional many-to-one association to DemandeEmprunt
	@OneToMany(mappedBy="compte1")
	private List<DemandeEmprunt> demandeEmprunts1;

	//bi-directional many-to-one association to DemandeEmprunt
	@OneToMany(mappedBy="compte2")
	private List<DemandeEmprunt> demandeEmprunts2;

	//bi-directional many-to-one association to Ouvrage
	@OneToMany(mappedBy="compte")
	private List<Ouvrage> ouvrages;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="compte")
	private List<Role> roles;

	public Compte() {
	}

	public Integer getIdcompte() {
		return this.idcompte;
	}

	public void setIdcompte(Integer idcompte) {
		this.idcompte = idcompte;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotdepasse() {
		return this.motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public List<DemandeAmi> getDemandeAmis1() {
		return this.demandeAmis1;
	}

	public void setDemandeAmis1(List<DemandeAmi> demandeAmis1) {
		this.demandeAmis1 = demandeAmis1;
	}

	public DemandeAmi addDemandeAmis1(DemandeAmi demandeAmis1) {
		getDemandeAmis1().add(demandeAmis1);
		demandeAmis1.setCompte1(this);

		return demandeAmis1;
	}

	public DemandeAmi removeDemandeAmis1(DemandeAmi demandeAmis1) {
		getDemandeAmis1().remove(demandeAmis1);
		demandeAmis1.setCompte1(null);

		return demandeAmis1;
	}

	public List<DemandeAmi> getDemandeAmis2() {
		return this.demandeAmis2;
	}

	public void setDemandeAmis2(List<DemandeAmi> demandeAmis2) {
		this.demandeAmis2 = demandeAmis2;
	}

	public DemandeAmi addDemandeAmis2(DemandeAmi demandeAmis2) {
		getDemandeAmis2().add(demandeAmis2);
		demandeAmis2.setCompte2(this);

		return demandeAmis2;
	}

	public DemandeAmi removeDemandeAmis2(DemandeAmi demandeAmis2) {
		getDemandeAmis2().remove(demandeAmis2);
		demandeAmis2.setCompte2(null);

		return demandeAmis2;
	}

	public List<DemandeEmprunt> getDemandeEmprunts1() {
		return this.demandeEmprunts1;
	}

	public void setDemandeEmprunts1(List<DemandeEmprunt> demandeEmprunts1) {
		this.demandeEmprunts1 = demandeEmprunts1;
	}

	public DemandeEmprunt addDemandeEmprunts1(DemandeEmprunt demandeEmprunts1) {
		getDemandeEmprunts1().add(demandeEmprunts1);
		demandeEmprunts1.setCompte1(this);

		return demandeEmprunts1;
	}

	public DemandeEmprunt removeDemandeEmprunts1(DemandeEmprunt demandeEmprunts1) {
		getDemandeEmprunts1().remove(demandeEmprunts1);
		demandeEmprunts1.setCompte1(null);

		return demandeEmprunts1;
	}

	public List<DemandeEmprunt> getDemandeEmprunts2() {
		return this.demandeEmprunts2;
	}

	public void setDemandeEmprunts2(List<DemandeEmprunt> demandeEmprunts2) {
		this.demandeEmprunts2 = demandeEmprunts2;
	}

	public DemandeEmprunt addDemandeEmprunts2(DemandeEmprunt demandeEmprunts2) {
		getDemandeEmprunts2().add(demandeEmprunts2);
		demandeEmprunts2.setCompte2(this);

		return demandeEmprunts2;
	}

	public DemandeEmprunt removeDemandeEmprunts2(DemandeEmprunt demandeEmprunts2) {
		getDemandeEmprunts2().remove(demandeEmprunts2);
		demandeEmprunts2.setCompte2(null);

		return demandeEmprunts2;
	}

	public List<Ouvrage> getOuvrages() {
		return this.ouvrages;
	}

	public void setOuvrages(List<Ouvrage> ouvrages) {
		this.ouvrages = ouvrages;
	}

	public Ouvrage addOuvrage(Ouvrage ouvrage) {
		getOuvrages().add(ouvrage);
		ouvrage.setProprietaire(this);

		return ouvrage;
	}

	public Ouvrage removeOuvrage(Ouvrage ouvrage) {
		getOuvrages().remove(ouvrage);
		ouvrage.setProprietaire(null);

		return ouvrage;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setCompte(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setCompte(null);

		return role;
	}

}