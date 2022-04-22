package com.ait.PaymentService.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.ait.PaymentService.payment.Payment;
import com.ait.PaymentService.repository.PaymentRepository;

@Service
@RestController


public class PaymentService {
	
	
	private PaymentRepository repository;

	public Payment doPayment(Payment payment) {
		payment.setTransactionId(UUID.randomUUID().toString());
		return repository.save(payment);
	}





	public void updatePayment(Long paymentId, String firstName, String lastName, String email, String address) {
		// TODO Auto-generated method stub
		
	}
	

		
		private final PaymentRepository paymentRepository;
		
		@Autowired
		public PaymentService(PaymentRepository paymentRepository) {
			this.paymentRepository = paymentRepository;
		}
		
		public List<Payment> getPayments1(){
			return paymentRepository.findAll();
					
		}
		
		public Optional<Payment> getPaymentId(Long id) {
			return paymentRepository.findById(id);
		}

		 
		public void addNewPayment1(Payment payment) {
			paymentRepository.save(payment);
		}

		public void deletePayment1(Long id) {
		
			paymentRepository.deleteById(id);
			
		}

		public Payment updatePayment(Long id, Payment payment)
		{
			Optional<Payment> optionalPayment = paymentRepository.findById(id);
			
			Payment existingPayment = optionalPayment.get();
			existingPayment.setFirstName(payment.getFirstName());
//			existingPayment.setlastName(payment.getlastName());
//			existingPayment.setEmail(payment.getEmail());
//			existingPayment.setAddress(payment.getAddress());
//			
			return paymentRepository.save(existingPayment);
		}

		
		


	}







