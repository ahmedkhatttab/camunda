package com.example.workflow.listeners.execution;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.Expression;
import org.camunda.bpm.engine.runtime.Execution;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MsgListener implements ExecutionListener {

    Expression event_st;
    @Override
    public void notify(DelegateExecution exe) throws Exception {

        String val = (String) event_st.getValue(exe);


        log.info("---------------------- inside execution listener ---------------------");
        log.info("event_st Var: {}",val);
        String test = (String) exe.getVariable("test");
        log.info("Test Var: {}",test);

//        String date = (String) exe.getVariable("event_st");
//        log.info("---------------------- inside execution listener ---------------------");
//        log.info("Started At: {}",date);


    }
}
