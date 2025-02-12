package com.spring.boot.course.journalapp.repository;

import com.spring.boot.course.journalapp.entity.ConfigJournalAppEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, String> {

}
