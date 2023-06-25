package com.example.workflow.listeners.task;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.Expression;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Slf4j
public class CompleteTaskListener implements TaskListener {

    Expression task_comp;

    @Override
    public void notify(DelegateTask exe) {

        Date date = (Date) task_comp.getValue(exe);
        log.info("---------------------- task completed at ---------------------");
        log.info("{}",date);

    }
}
