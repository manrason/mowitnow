package com.test.technique.mowitnow.mowitnow;

import com.test.technique.mowitnow.mowitnow.config.MowItNowBatchConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MowitnowApplication implements CommandLineRunner {

	private final MowItNowBatchConfiguration mowItNowBatchConfiguration;

    public MowitnowApplication(MowItNowBatchConfiguration mowItNowBatchConfiguration) {
        this.mowItNowBatchConfiguration = mowItNowBatchConfiguration;
    }

    public static void main(String[] args) {
		SpringApplication.run(MowitnowApplication.class, args);
	}

	@Override
	public void run(String... args) {
		mowItNowBatchConfiguration.job();
	}
}
