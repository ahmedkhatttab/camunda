package com.example.workflow.serviceTasks;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CallActivityBean implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String empName = (String) execution.getVariable("emp_name");

        log.info("::::::::::::::::::::SUB-PROCESS:::::::::::::::::::::::::::");
        log.info("EMPLOYEE NAME: {}", empName);
    }
}
