package br.edu.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.edu.hruser.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
