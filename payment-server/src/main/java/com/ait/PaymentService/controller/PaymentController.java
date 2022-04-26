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

import com.ait.PaymentService.FeignClient.PaymentServiceFeignClient;
import com.ait.PaymentService.payment.Payment;
import com.ait.PaymentService.service.PaymentService;
import com.ait.UserService.User.User;
import com.netflix.discovery.DiscoveryClient;


@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	

	private final PaymentService service;
	@Autowired
	private PaymentServiceFeignClient paymentServiceFeignClient;
	
	private DiscoveryClient discoveryClient;

	@Autowired
	public PaymentController(PaymentService service) {
		this.service = service;
	}
	


	@RequestMapping(value="/payment-user-feign/{userId}",method=RequestMethod.GET)
	public User drinkSomeWine(@PathVariable(value="userId") int userId) {
		return paymentServiceFeignClient.getUserById(userId);
	
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
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Optional<Payment> getpaymentId1(@PathVariable Long id)
	{
		return service.getPaymentId(id);
	}
	
//	@PostMapping("/doPayment")
//	public void registerNewPayment(@RequestBody Payment payment) {
//		service.addNewPayment1(payment);
//	}
	@DeleteMapping(path = "/{id}")
	public void deletePayment(@PathVariable("id") Long paymentId) {
		service.deletePayment(paymentId);
	}

	@PutMapping(path = "{paymentId}")
	public void updatePayment(@PathVariable("paymentId") Long paymentId,
			@RequestParam(required = false) String paymentName, @RequestParam(required = false) String paymentAddress,
			@RequestParam(required = false) String paymentCode)
	 
	 {

		service.updatePayment(paymentId, paymentName, paymentAddress,paymentCode);
	}
}
	
	

	
//
//
//    @Autowired
//    private PaymentService paymentService;
//	@GetMapping
//	public List<Payment> getPayments() {
//		return paymentService.getPayments();
//	}
//    
//
//    @PostMapping("/")
//    public Payment savePayment(@RequestBody Payment payment) {
////        log.info("Inside savePayment method of PaymentController");
//        return paymentService.savePayment(payment);
//    }
//
//    @GetMapping("/{id}")
//    public Payment findPaymentById(@PathVariable("id") Long paymentId) {
////        log.info("Inside findPaymentById method of PaymentController");
//        return ((PaymentService) paymentService).findPaymentById(paymentId);
//    }
//
//}
