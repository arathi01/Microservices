package com.ait.PaymentService.FeignClient;




import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ait.UserService.User.User;



@FeignClient("user-service")
public interface PaymentServiceFeignClient {
	@GetMapping("/users/{userId}")
	User getUserById(@PathVariable("userId") int userId);

}
