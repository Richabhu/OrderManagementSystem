package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OrderManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementSystemApplication.class, args);


		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(1);
		arr.add(1);
		arr.add(1);

		int sum = 0;

		for(int i: arr){
			sum+=i;
		}

//
//		Hashing Algo = %10;
//		data -> 1 to 10
//			1%10 ->1





	}

}
