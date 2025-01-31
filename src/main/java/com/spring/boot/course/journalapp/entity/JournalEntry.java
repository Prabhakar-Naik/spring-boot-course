package com.spring.boot.course.journalapp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@Document
public class JournalEntry {
    @Id
    private String id;
    private String title;
    private String description;
    private String author;
    private LocalDate publishDate;

}
