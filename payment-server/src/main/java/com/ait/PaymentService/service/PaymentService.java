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
	

	private PaymentRepository paymentrepository;

//	public Payment doPayment(Payment payment) {
////		payment.setTransactionId(UUID.randomUUID().toString());
//		return repository.save(payment);
//	}

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
			existingPayment.setPaymentAddress(payment.getPaymentAddress());
//			existingPayment.setlastName(payment.getlastName());
//			existingPayment.setEmail(payment.getEmail());
//			existingPayment.setAddress(payment.getAddress());
//			
			return paymentRepository.save(existingPayment);
		}

		public void updatePayment(Long paymentId, String paymentName, String paymentAddress, String paymentCode) {
			// TODO Auto-generated method stub
			
		}

		public void deletePayment(Long paymentId) {
			// TODO Auto-generated method stub
			
		}

	

		
		


	}

	
	

//
//	    @Autowired
//	    private PaymentRepository paymentRepository;
//
//	    public Payment savePayment(Payment payment) {
////	        log.info("Inside savePayment of PaymentService");
//	        return paymentRepository.save(payment);
//	    }
//
//	    public Payment findPaymentById(Long paymentId) {
////	        log.info("Inside savePayment of PaymentService");
//	        return paymentRepository.findByPaymentId(paymentId);
//	    }
//
//		public List<Payment> getPayments1() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		public List<Payment> getPayments() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
////		public Payment savePayment(Payment payment) {
////			// TODO Auto-generated method stub
////			return null;
////		}
//
//	
//	}
//
//
//
//
//
