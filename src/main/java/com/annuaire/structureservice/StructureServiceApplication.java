package com.annuaire.structureservice;

import com.annuaire.structureservice.model.Param;
import com.annuaire.structureservice.repository.ParamRepository;
import com.annuaire.structureservice.service.SequenceGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.annuaire.structureservice.model.Param.SEQUENCE_NAME;

/**
 * @author karim hmadi

 * @description structure application

 */
@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories(basePackages = "com.annuaire.structureservice")

public class StructureServiceApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(StructureServiceApplication.class, args);
	}

}
