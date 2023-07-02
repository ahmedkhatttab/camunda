package com.example.workflow.controller;

import com.example.workflow.dto.mapper.Gender;
import com.example.workflow.dto.mapper.UserDto;
import com.example.workflow.utils.EMail;
import com.example.workflow.utils.EMailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class RestConnector {


    private final RuntimeService runtimeService;

//    private final EMailService eMailService;


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){

        UserDto user =null;

        if(id==1L) {
            user = new UserDto(1L, "Ahmed", "Khatab",
                    LocalDateTime.of(1984, 2, 19, 0, 0),
                    Gender.MALE, new BigDecimal(20000)
            );
        }

        return ResponseEntity.ok(user);
    }


    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){

        Random random = new Random();
        long randomNumber = random.nextInt(100)+1;

        user = new UserDto(randomNumber, user.getFirstName(), user.getLastName(),
                LocalDateTime.of(1984, 2,19,0,0),
                user.getGender(), user.getSalary());

        return ResponseEntity.ok(user);
    }


    @GetMapping("/email")
    ResponseEntity<String> sendEmail(EMail eMail){
//        eMailService.sendEmail(eMail.getTo(), eMail.getSubject(), eMail.getBody());
        return ResponseEntity.ok("Success");
    }

}
