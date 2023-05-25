package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the role database table.
 * 
 */
@Embeddable
public class RolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer idcompte;

	private String role;

	public RolePK() {
	}
	public Integer getIdcompte() {
		return this.idcompte;
	}
	public void setIdcompte(Integer idcompte) {
		this.idcompte = idcompte;
	}
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolePK)) {
			return false;
		}
		RolePK castOther = (RolePK)other;
		return 
			this.idcompte.equals(castOther.idcompte)
			&& this.role.equals(castOther.role);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idcompte.hashCode();
		hash = hash * prime + this.role.hashCode();
		
		return hash;
	}
}