package com.spring.boot.course.journalapp.repository;

import com.spring.boot.course.journalapp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserName(String username);

    void deleteByUserName(String username);
}
