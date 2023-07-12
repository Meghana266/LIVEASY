package com.liveasy.liveasy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class LiveasyApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(LiveasyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.createTable();
	}

	public void createTable() {
        String query = "CREATE TABLE if not exists load(loadId serial primary key,loadingPoint varchar(255) not null,unloadingPoint varchar(255) not null,productType varchar(255) not null,truckType varchar(255) not null,noOfTrucks int not null,weight int not null,comment varchar(1000),shipperId varchar(255) not null,Date varchar(12) not null)";
        this.jdbcTemplate.update(query);
    }

}
