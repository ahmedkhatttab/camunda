package com.example.workflow.dto.mapper;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ProcessInstanceMapper {

    private String processDefKey;
    private String processDefinitionId;
    private String id;
    private String processInstanceId;
    private String rootProcessInstanceId;
    private String caseInstanceId;
    private String businessKey;
    private String tenantId;
}
