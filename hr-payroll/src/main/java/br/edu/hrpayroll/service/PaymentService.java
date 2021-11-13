package br.edu.hrpayroll.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.edu.hrpayroll.entities.Payment;
import br.edu.hrpayroll.entities.Worker;
import br.edu.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerid, int days){
		
		Worker worker = workerFeignClient.findId(workerid).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(),days);
	}
	
}
