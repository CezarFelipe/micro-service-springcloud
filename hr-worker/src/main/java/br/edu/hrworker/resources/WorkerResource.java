package br.edu.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.hrworker.entities.Worker;
import br.edu.hrworker.repository.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Value("${test.config}")
	private String testConfig;

	private static Logger logger = LoggerFactory.getLogger(WorkerRepository.class);

	@Autowired
	private Environment env;

	@Autowired
	private WorkerRepository repository;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findId(@PathVariable Long id) {

		/*
		 * try { Thread.sleep(3000l); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		logger.info("PORT ===" + env.getProperty("local.server.port"));

		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}

	@GetMapping(value = "/configs")
	public ResponseEntity<String> getConfigs() {

		String log = "CONFIG == " + testConfig;

		logger.info(log);

		return new ResponseEntity<String>(log, HttpStatus.OK);

	}
}
