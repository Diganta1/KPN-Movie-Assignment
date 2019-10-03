package com.kpn.nl.batch.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kpn.nl.batch.operation.MovieItemProcessor;
import com.kpn.nl.model.Actor;
import com.kpn.nl.model.Movie;
import com.kpn.nl.model.Profile;
import com.kpn.nl.repository.MovieRepository;
import com.kpn.nl.service.impl.UserServiceimpl;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	EntityManagerFactory emf;

	@Autowired
	MovieRepository movieRepository;

	@Bean
	public MovieItemProcessor processor() {
		return new MovieItemProcessor();
	}

	@Bean
	public StaxEventItemReader<Movie> reader() {
		StaxEventItemReader<Movie> reader = new StaxEventItemReader<Movie>();
		reader.setResource(new ClassPathResource("movies.xml"));
		reader.setFragmentRootElementName("movie");
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Movie.class,Actor.class);
		reader.setUnmarshaller(marshaller);
		return reader;
	}
	
	@Bean
	public JpaItemWriter<Movie> writer() {
		JpaItemWriter<Movie> writer = new JpaItemWriter<Movie>();
		writer.setEntityManagerFactory(emf);
		return writer;
	}
	
	@Bean
	public Job importUserJob(JobExecutionListener listener) {
		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener)
				.flow(step1()).end().build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Movie, Movie>chunk(10).reader(reader()).processor(processor())
				.writer(writer()).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobExecutionListener() {

			@Override
			public void beforeJob(JobExecution jobExecution) {
				
			}

			@Override
			public void afterJob(JobExecution jobExecution) {

			}
		};
	}
	
	@Bean
	CommandLineRunner runner(UserServiceimpl userService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
			TypeReference<List<Profile>> typeReference = new TypeReference<List<Profile>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/profiles.json");
			try {
				List<Profile> users = mapper.readValue(inputStream,typeReference);
				userService.save(users);
			} catch (IOException e){
			}
		};
	}	

}