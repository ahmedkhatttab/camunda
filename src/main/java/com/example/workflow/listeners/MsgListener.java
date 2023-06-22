package com.example.workflow.listeners;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MsgListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution exe) throws Exception {

    }
}
