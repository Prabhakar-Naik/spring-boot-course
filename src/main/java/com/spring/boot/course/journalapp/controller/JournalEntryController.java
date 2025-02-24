package com.spring.boot.course.journalapp.controller;

import com.spring.boot.course.journalapp.entity.JournalEntry;
import com.spring.boot.course.journalapp.entity.User;
import com.spring.boot.course.journalapp.service.JournalEntryService;
import com.spring.boot.course.journalapp.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/journals")
@Tag(name = "Journal APIs")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getJournalEntriesByUser")
    public ResponseEntity<?> getAllJournalEntriesByUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = this.userService.getUserByName(username);
        List<JournalEntry> all = Objects.requireNonNull(user.getJournalEntries());
        if (!all.isEmpty() && all != null) {
            return ResponseEntity.ok(all);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping(value = "/saveJournalEntry")
    public ResponseEntity<String> saveJournalEntry(@RequestBody JournalEntry journalEntry) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        String response = this.journalEntryService.saveEntry(journalEntry, userName);
        if (response.equals("User not found"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        else
            return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping(value = "/updateJournalEntry")
    public ResponseEntity<JournalEntry> updateJournalEntry(@RequestBody JournalEntry journalEntry) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = this.userService.getUserByName(userName);
        List<JournalEntry> journalEntries = user.getJournalEntries()
                .stream()
                .filter(x -> x.getId().equals(journalEntry.getId()))
                .toList();
        if (!journalEntries.isEmpty()) {
            JournalEntry updated = journalEntryService.update(journalEntry);
            if (updated != null)
                return ResponseEntity.ok(updated);
            else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/getJournalEntryById/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.getUserByName(userName);
        List<JournalEntry> journalEntries = user.getJournalEntries()
                .stream()
                .filter(x -> x.getId().equals(id))
                .toList();
        if (!journalEntries.isEmpty() && journalEntries != null) {
            if (this.journalEntryService.findById(id) != null)
                return ResponseEntity.ok(this.journalEntryService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/deleteJournalEntryById/{id}")
    public ResponseEntity<String> deleteJournalEntryById(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
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
