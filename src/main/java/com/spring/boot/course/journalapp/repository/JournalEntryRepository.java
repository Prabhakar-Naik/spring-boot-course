package com.spring.boot.course.journalapp.repository;

import com.spring.boot.course.journalapp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {

}
