package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    JobRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        Job job;
        job = new Job("Data Analyst", "This is a job for a Data Analyst in Washington DC",
                "November 25", "Prasanti", "1234567890");
        repository.save(job);

        job = new Job("Bioinformatics Analyst", "This is a job for a Bioinformatics Analyst in Fremont, CA",
                "November 23", "Prasanti", "0001112222");
        repository.save(job);
    }
}
