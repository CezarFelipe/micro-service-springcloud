package br.edu.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.edu.hrpayroll.entities.Payment;
import br.edu.hrpayroll.service.PaymentService;

@RestController
@RequestMapping(value="/payments")
public class PaymentResource {
	
	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value ="/{workerId}/days/{days}")
	public ResponseEntity<Payment>getPayment(@PathVariable Long workerId, @PathVariable int days){
		Payment payment =service.getPayment(workerId, days);
		
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<Payment>getPaymentAlternative(Long workerId,int days){
		Payment payment = new Payment("Cezar",5.000, 30);
		
		return ResponseEntity.ok(payment);
	}

}
