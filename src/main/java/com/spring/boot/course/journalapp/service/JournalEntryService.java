package com.spring.boot.course.journalapp.service;

import com.spring.boot.course.journalapp.entity.JournalEntry;
import com.spring.boot.course.journalapp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void save(JournalEntry journalEntry) {
        journalEntry.setId(UUID.randomUUID().toString());
        journalEntry.setPublishDate(LocalDate.now());
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> findAll() {
        return journalEntryRepository.findAll();
    }

    public JournalEntry findById(String id) {
        return this.journalEntryRepository.findById(id).orElse(null);
    }

    public void update(JournalEntry journalEntry) {
        JournalEntry old = this.journalEntryRepository.findById(journalEntry.getId()).orElse(null);

        if (old != null) {

            old.setTitle(journalEntry.getTitle() != null &&
                    !journalEntry.getTitle().isEmpty() ?
                    journalEntry.getTitle() : old.getTitle());

            old.setDescription(journalEntry.getDescription() != null &&
                    !journalEntry.getDescription().isEmpty() ?
                    journalEntry.getDescription() : old.getDescription());

            old.setAuthor(journalEntry.getAuthor() != null &&
                    !journalEntry.getAuthor().isEmpty() ?
                    journalEntry.getAuthor() : old.getAuthor());

            old.setPublishDate(!Objects.equals(
                    journalEntry.getPublishDate(), LocalDate.now()) ?
                    LocalDate.now() : old.getPublishDate()
            );
            this.journalEntryRepository.save(old);
        }
        // or
        /*if (old.isPresent()) {
            old.get().setTitle(journalEntry.getTitle());
            old.get().setDescription(journalEntry.getDescription());
            old.get().setAuthor(journalEntry.getAuthor());
            old.get().setPublishDate(LocalDate.now());
            journalEntryRepository.save(old.get());
        }*/

    }

    public void deleteById(String id) {
        journalEntryRepository.deleteById(id);
    }



}
