package com.example.workflow.controller;

import com.example.workflow.dto.mapper.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class RestConnector {


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){

        if(id==1L) {
            UserDto user = new UserDto(1L, "Ahmed", "Khatab",
                    LocalDateTime.of(1984, 2, 19, 0, 0));

            return ResponseEntity.ok(user);
        }

        return ResponseEntity.ok(null);
    }


    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){

        Random random = new Random();
        long randomNumber = random.nextInt(100)+1;

        user = new UserDto(randomNumber, user.getFirstName(), user.getLastName(),
                LocalDateTime.of(1984, 2,19,0,0));

        return ResponseEntity.ok(user);
    }

}
