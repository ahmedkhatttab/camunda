package com.example.workflow.serviceTask;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DecisionBean implements JavaDelegate {


    @Override
    public void execute(DelegateExecution e) throws Exception {
        int vacation_nod = (int) e.getVariable("vac_len");

        log.info("---------------------- VACATION NOD --------------------------");
        log.info("{}", vacation_nod);
    }
}
