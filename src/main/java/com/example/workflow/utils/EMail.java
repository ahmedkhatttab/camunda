package com.example.workflow.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EMail {

    private String to;

    private String subject;

    private String body;
}
