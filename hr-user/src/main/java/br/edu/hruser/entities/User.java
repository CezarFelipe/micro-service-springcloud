package br.edu.hruser.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_user")
public class User implements Serializable {
	
	

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true)
private String email;

private String password;
private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(
		name = "tb_user_role",  // DEFINE NOME DA TABELA
		joinColumns = @JoinColumn(name="user_id"), // DEFINE O NOME DA COLUNA REFERENTE A PRIMARY KEY DESTA TABELA
		inverseJoinColumns = @JoinColumn(name="role_id") // DEFINE O NOME DA COLUNA REFERENTE A PRIMARY KEY DA TABELA RELACIONAL
		)
private Set<Role>roles = new HashSet<>();

public User() {
	
}

public User(Long id, String email, String password) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


public Set<Role> getRoles() {
	return roles;
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(id, other.id);
}

}
