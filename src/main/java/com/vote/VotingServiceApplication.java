package com.vote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.vote.core.dao.api")
public class VotingServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(VotingServiceApplication.class, args);
  }
}
