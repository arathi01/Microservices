package com.ait.PaymentService.payment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name ="PaymentTable")
public class Payment {
	
	@Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;
    private String paymentName;
    private String paymentAddress;
    private String paymentCode;
    
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	public String getPaymentAddress() {
		return paymentAddress;
	}
	public void setPaymentAddress(String paymentAddress) {
		this.paymentAddress = paymentAddress;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	@Override
	public String toString() {
		return "Payment [paymentName=" + paymentName + ", paymentAddress=" + paymentAddress + ", paymentCode="
				+ paymentCode + "]";
	}
	public void setTransactionId(String string) {
		// TODO Auto-generated method stub
		
	}
}


	


