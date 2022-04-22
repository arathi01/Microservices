//package com.ait.PaymentService;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.net.http.HttpHeaders;
//
//import org.apache.http.HttpEntity;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.HttpClientErrorException;
//
//import com.ait.PaymentService.payment.Payment;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Payment.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class PaymentControllerTests {
//	@Autowired
//	private TestRestTemplate restTemplate;
//
//	@LocalServerPort
//	private int port;
//
//	private String getRootUrl() {
//		return "http://localhost:" + port;
//	}
//
//	@Test
//	public void contextLoads() {
//
//	}
//
//	@Test
//	public void testGetAllPayments() {
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//
//		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/paymentId",
//				HttpMethod.GET, entity, String.class);
//		
//		assertNotNull(response.getBody());
//	}
//
//	@Test
//	public void testGetPaymentById() {
//		Payment payment = restTemplate.getForObject(getRootUrl() + "/payment/1", Payment.class);
//		System.out.println(payment.getFirstName());
//		assertNotNull(payment);
//	}
//
//	@Test
//	public void testCreatePayment() {
//		Payment payment = new Payment(port, null, null, null, null, null, null);
//		payment.setEmail("admin@gmail.com");
//		payment.setFirstName("admin");
//		payment.setLastName("admin");
//
//		ResponseEntity<Payment> postResponse = restTemplate.postForEntity(getRootUrl() + "/payment", payment, Payment.class);
//		assertNotNull(postResponse);
//		assertNotNull(postResponse.getBody());
//	}
//
//	@Test
//	public void testUpdatePayment() {
//		int id = 1;
//		Payment Payment = restTemplate.getForObject(getRootUrl() + "/paymentId/" + id, Payment.class);
//		com.ait.PaymentService.payment.Payment payment;
//		payment.setFirstName("admin1");
//		payment.setLastName("admin2");
//
//		restTemplate.put(getRootUrl() + "/paymentId/" + id, payment);
//
//		Payment updatedPayment = restTemplate.getForObject(getRootUrl() + "/paymentId/" + id, Payment.class);
//		assertNotNull(updatedPayment);
//	}
//
//	@Test
//	public void testDeletePayment() {
//		int id = 2;
//		Payment payment = restTemplate.getForObject(getRootUrl() + "/paymentId/" + id, Payment.class);
//		assertNotNull(payment);
//
//		restTemplate.delete(getRootUrl() + "/paymentId/" + id);
//
//		try {
//			payment = restTemplate.getForObject(getRootUrl() + "/paymentId/" + id, Payment.class);
//		} catch (final HttpClientErrorException e) {
//			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//		}
//	}
//}