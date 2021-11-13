package br.edu.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
