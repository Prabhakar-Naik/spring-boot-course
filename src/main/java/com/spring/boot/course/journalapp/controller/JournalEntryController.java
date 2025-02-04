package com.spring.boot.course.journalapp.controller;

import com.spring.boot.course.journalapp.entity.JournalEntry;
import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.service.JournalEntryService;
import com.spring.boot.course.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
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
        String response = this.journalEntryService.saveEntry(journalEntry, userName);
        if (response.equals("User not found"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        else
            return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping(value = "/updateJournalEntry")
    public ResponseEntity<JournalEntry> updateJournalEntry(@RequestBody JournalEntry journalEntry) {
        JournalEntry updated = journalEntryService.update(journalEntry);
        if (updated != null)
            return ResponseEntity.ok(updated);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping(value = "/getJournalEntryById/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable String id) {
        if (this.journalEntryService.findById(id) != null)
            return ResponseEntity.ok(this.journalEntryService.findById(id));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/deleteJournalEntryById/{userName}/{id}")
    public ResponseEntity<String> deleteJournalEntryById(@PathVariable String id, @PathVariable String userName) {
        boolean delete = journalEntryService.deleteById(id, userName);
        if (delete)
            return ResponseEntity.ok("Successfully deleted journal entry " + delete + " " + id);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        String response = this.journalEntryService.deleteById(id);
        if (response.equals("Deleted Successfully"))
            return ResponseEntity.ok(response);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping(value = "/getAllJournalEntries")
    public ResponseEntity<List<JournalEntry>> getAllJournalEntries() {
        return ResponseEntity.ok(this.journalEntryService.findAll());
    }

    @GetMapping("/current-time-ist")
    public String getCurrentTimeIst() {
        ZoneId istZoneId = ZoneId.of("Asia/Kolkata");
        ZonedDateTime istDateTime = ZonedDateTime.now(istZoneId);
        return "Current time in IST: " + istDateTime;
    }


}
