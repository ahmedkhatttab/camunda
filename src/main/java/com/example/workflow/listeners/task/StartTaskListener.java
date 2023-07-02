package com.example.workflow.listeners.task;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.Expression;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class StartTaskListener implements TaskListener {

    Expression task_st;

    @Override
    public void notify(DelegateTask exe) {

        Date date = (Date) task_st.getValue(exe);
        log.info("---------------------- task starts at ---------------------");
        log.info("{}",date);

    }
}
