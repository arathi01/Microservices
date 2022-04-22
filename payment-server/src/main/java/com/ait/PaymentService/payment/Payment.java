package com.ait.PaymentService.payment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name ="Payment_TB")
public class Payment {
	
	@Id
	@GeneratedValue
	
	private Long paymentId;
	private String paymentStatus;
	private String transactionId;
	private String firstName;
	private String lastName;
//	@Transient
	private String email;
	private String address;
	public Payment(long i, String string, String j, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated constructor stub
	}
	
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentStatus=" + paymentStatus + ", transactionId="
				+ transactionId + ", firstName=" + firstName + ", lastName=" + lastName + ",email="
				+ email + ", address=" + address + "]";
	}
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object run() {
		// TODO Auto-generated method stub
		return null;
	}


	
	

	
}

