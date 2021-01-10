package com.lti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}

}



//
//@Access(AccessType.PROPERTY)@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)@JoinColumn(name="userId")public User getUser() {​​
//    return user;
//}​​