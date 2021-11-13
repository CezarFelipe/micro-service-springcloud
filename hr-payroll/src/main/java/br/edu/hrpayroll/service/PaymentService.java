package br.edu.hrpayroll.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.hrpayroll.entities.Payment;
import br.edu.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerid, int days){
		
		Map<String, String> uriVaribles = new HashMap<>();
		uriVaribles.put("id", ""+workerid);
		
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVaribles);
		
		return new Payment(worker.getName(), worker.getDailyIncome(),days);
	}
	
}
