package com.spring.boot.course.journalapp.service;

import com.spring.boot.course.journalapp.entity.User;
import lombok.Builder;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class UserArgumentProvider implements ArgumentsProvider {


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
//                Arguments.of(User.builder().userName("prabhakar123").password("prabhakar123").build()),
//                Arguments.of(User.builder().userName("suraj225").password("suraj225").build())
        );
    }
}
