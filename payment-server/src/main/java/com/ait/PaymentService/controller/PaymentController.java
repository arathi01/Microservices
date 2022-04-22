package com.ait.PaymentService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ait.PaymentService.payment.Payment;
import com.ait.PaymentService.service.PaymentService;


@RestController
@RequestMapping("/payment")
public class PaymentController {
	

	private final PaymentService service;

	@Autowired
	public PaymentController(PaymentService service) {
		this.service = service;
	}
	@GetMapping
	public List<Payment> getPayments() {
		return service.getPayments1();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Payment> getpaymentId(@PathVariable Long id)
	{
		return service.getPaymentId(id);
	}
	
	@PostMapping("/doPayment")
	public void registerNewPayment(@RequestBody Payment payment) {
		service.addNewPayment1(payment);
	}
	@DeleteMapping(path = "{id}")
	public void deletePayment(@PathVariable("id") Long id) {
		service.deletePayment1(id);
	}

	@PutMapping(path = "{paymentId}")
	public void updatePayment(@PathVariable("paymentId") Long paymentId,
			@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName,
			@RequestParam(required = false) String email, @RequestParam(required = false) String address)
	 
	 {

		service.updatePayment(paymentId, firstName, lastName, email, address);
	}
}