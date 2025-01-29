package com.spring.boot.course.journalapp.controller;

import com.spring.boot.course.journalapp.entity.JournalEntry;
import com.spring.boot.course.journalapp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/journals")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping(value = "/getAllJournalEntries")
    public ResponseEntity<List<JournalEntry>> getAllJournalEntries() {
        return ResponseEntity.ok(this.journalEntryService.findAll());
    }

    @PostMapping(value = "/saveJournalEntry")
    public ResponseEntity<String> saveJournalEntry(@RequestBody JournalEntry journalEntry) {
        journalEntryService.save(journalEntry);
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


}
