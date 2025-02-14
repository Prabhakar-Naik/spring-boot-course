package com.spring.boot.course.journalapp.service;

import com.spring.boot.course.journalapp.entity.ConfigJournalAppEntity;
import com.spring.boot.course.journalapp.repository.ConfigJournalAppRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConfigService {

    private final ConfigJournalAppRepository configJournalAppRepository;

    public ConfigService(ConfigJournalAppRepository configJournalAppRepository) {
        this.configJournalAppRepository = configJournalAppRepository;
    }

    public String saveCredentials(ConfigJournalAppEntity entity){
        entity.setId(UUID.randomUUID().toString());
        ConfigJournalAppEntity save = this.configJournalAppRepository.save(entity);
        return save.getId();
    }

    public List<ConfigJournalAppEntity> getAll(){
        return this.configJournalAppRepository.findAll();
    }

}
