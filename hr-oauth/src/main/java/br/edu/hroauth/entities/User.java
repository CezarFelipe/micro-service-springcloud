package br.edu.hroauth.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User implements Serializable {
	
	

private static final long serialVersionUID = 1L;


private Long id;

private String email;

private String password;
private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

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
