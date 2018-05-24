package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.support.ErrorMessage;

@SpringBootApplication
@EnableBinding(Sink.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void listen(byte[] in) {
		throw new RuntimeException("fail");
	}

	@ServiceActivator(inputChannel = "errorChannel")
	public void errors(ErrorMessage em) {
		System.out.println(em);
	}
}
