package com.spring.boot.course.journalapp.controller;

import com.spring.boot.course.journalapp.entity.JournalEntry;
import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.service.JournalEntryService;
import com.spring.boot.course.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/journals")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getJournalEntriesByUser/{userName}")
    public ResponseEntity<?> getAllJournalEntriesByUser(@PathVariable String userName) {
        User user = this.userService.getUserByName(userName);
        List<JournalEntry> all = Objects.requireNonNull(user.getJournalEntries());
        if (!all.isEmpty() && all != null) {
            return ResponseEntity.ok(all);
        }
        return ResponseEntity.notFound().build();
    }



    @PostMapping(value = "/saveJournalEntry/{userName}")
    public ResponseEntity<String> saveJournalEntry(@RequestBody JournalEntry journalEntry, @PathVariable String userName) {
        this.journalEntryService.saveEntry(journalEntry, userName);
        return ResponseEntity.ok("Successfully saved journal entry "+ journalEntry);
    }

    @PutMapping(value = "/updateJournalEntry")
    public ResponseEntity<String> updateJournalEntry(@RequestBody JournalEntry journalEntry) {
        journalEntryService.update(journalEntry);
        return ResponseEntity.ok("Successfully updated journal entry "+ journalEntry);
    }

    @GetMapping(value = "/getJournalEntryById/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable String id) {
        return ResponseEntity.ok(this.journalEntryService.findById(id));
    }

    @DeleteMapping("/deleteJournalEntryById/{id}")
    public ResponseEntity<String> deleteJournalEntryById(@PathVariable String id) {
        journalEntryService.deleteById(id);
        return ResponseEntity.ok("Successfully deleted journal entry "+ id);
    }

    @GetMapping(value = "/getAllJournalEntries")
    public ResponseEntity<List<JournalEntry>> getAllJournalEntries() {
        return ResponseEntity.ok(this.journalEntryService.findAll());
    }

}
