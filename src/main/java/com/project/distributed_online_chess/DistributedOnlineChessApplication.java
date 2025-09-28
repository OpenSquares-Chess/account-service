package com.project.distributed_online_chess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.project.distributed_online_chess.dao")
public class DistributedOnlineChessApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedOnlineChessApplication.class, args);
	}

}
