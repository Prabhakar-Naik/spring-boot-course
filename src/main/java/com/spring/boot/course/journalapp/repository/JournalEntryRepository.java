package com.spring.boot.course.journalapp.repository;

import com.spring.boot.course.journalapp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

//@EnableMongoRepositories(basePackageClasses = JournalEntryRepository.class)
@Repository
public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {

}
