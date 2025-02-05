package com.spring.boot.course.journalapp.service;

import com.spring.boot.course.journalapp.entity.JournalEntry;
import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

//    @Transactional
    public String saveEntry(JournalEntry journalEntry, String userName) {
        try {
            User user = userService.getUserByName(userName);
            if (user == null) {
                return "User not found";
            }
            journalEntry.setId(UUID.randomUUID().toString());
            journalEntry.setPublishDate(LocalDate.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
            return "Successfully saved journal entry "+ journalEntry;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> findAll() {
        return journalEntryRepository.findAll();
    }

    public JournalEntry findById(String id) {
        return this.journalEntryRepository.findById(id).orElse(null);
    }

    public JournalEntry update(JournalEntry journalEntry) {
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
            return old;
        }
        return null;
        // or
        /*if (old.isPresent()) {
            old.get().setTitle(journalEntry.getTitle());
            old.get().setDescription(journalEntry.getDescription());
            old.get().setAuthor(journalEntry.getAuthor());
            old.get().setPublishDate(LocalDate.now());
            journalEntryRepository.save(old.get());
        }*/

    }

    public String deleteById(String id) {
        Optional<JournalEntry> journalEntry = this.journalEntryRepository.findById(id);
        if (journalEntry.isPresent()) {
            journalEntryRepository.delete(journalEntry.get());
            return "Deleted Successfully";
        }else
            return "Entry Not Found with --> "+ id;

    }

    @Transactional
    public boolean deleteById(String id, String userName) {
        boolean removed = false;
        try {
            User user = this.userService.getUserByName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removed) {
                this.userService.saveUser(user);
                this.journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
            //log.error("Error ",e);
            throw new RuntimeException("An error occurred while deleting the entry.", e);
        }
        return removed;
    }



}
