package br.edu.hrpayroll.service;


import org.springframework.stereotype.Service;

import br.edu.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long workerid, int days){
		return new Payment("Bob", 200.00,days);
	}

}
