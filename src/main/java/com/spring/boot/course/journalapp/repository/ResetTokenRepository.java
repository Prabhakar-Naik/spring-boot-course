package com.spring.boot.course.journalapp.repository;

import com.spring.boot.course.journalapp.entity.ResetToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author prabhakar, @Date 26-02-2025
 */

@Repository
public interface ResetTokenRepository extends MongoRepository<ResetToken, String> {
    Optional<ResetToken> findByToken(String token);
}
