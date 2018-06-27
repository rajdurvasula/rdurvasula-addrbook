package net.rdurvasula.addrbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RdurvasulaAddrbookApplication implements CommandLineRunner {

	@Autowired
	ContactRepository contactRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(RdurvasulaAddrbookApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		contactRepo.deleteAll();
	}
}
