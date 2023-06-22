package com.example.workflow.controller;


import com.example.workflow.dto.mapper.ProcessInstanceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.MessageCorrelationBuilder;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/process")
@Slf4j
@RequiredArgsConstructor
public class StartMessageProcess {

    private final RuntimeService runtimeService;

    private final RepositoryService repositoryService;


    @GetMapping("/messages/{messageName}")
    public ResponseEntity<?> startProcessByMessageId(@PathVariable String messageName){

        MessageCorrelationBuilder processInstanceId = runtimeService.createMessageCorrelation(messageName);

        processInstanceId.correlate();

        return ResponseEntity.ok().body("Process Started");
    }


    @GetMapping("/{processDefKey}/messages/{messageName}")
    public ResponseEntity<ProcessInstanceMapper> startProcess(
            @PathVariable String messageName, @PathVariable String processDefKey){

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(processDefKey)
                .latestVersion()
                .singleResult();

        String processDefinitionId = processDefinition.getId();

        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByMessageAndProcessDefinitionId(messageName, processDefinitionId);

        ProcessInstanceMapper mapper = ProcessInstanceMapper.builder()
                .processDefKey(processDefKey)
                .processDefinitionId(processInstance.getProcessDefinitionId())
                .id(processInstance.getId())
                .rootProcessInstanceId(processInstance.getRootProcessInstanceId())
                .processInstanceId(processInstance.getProcessInstanceId())
                .caseInstanceId(processInstance.getCaseInstanceId())
                .businessKey(processInstance.getBusinessKey())
                .tenantId(processInstance.getTenantId())
                .build();

        return ResponseEntity.ok().body(mapper);
    }

}
