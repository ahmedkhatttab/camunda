# Camunda

### What is the diff between MessageTask and MessageEvent?
MessageTasks are used to send messages from within a process, while MessageEvents are used to receive messages 
from external systems or other process instances.

### What is the diff between "#" and "$" in Modeler Expressions?
"#" indicates that the expression is a JavaScript Exp that should be evaluated using the JavaScript engine , 
while "$" indicates that the expression is a Camunda Exp that should be evaluated using the Camunda expression language.
Javascript exp are more complex expressions that require conditional logic, loops, etc... 
while Camunda exp are simplified expression that can contain references to process variables, functions, and 
operators, and can be used to perform simple calculations and transformations.

### What is the diff between execution listeners and task listeners?
They are types of event listeners that can be used to listen for and respond to events that occur during the 
execution of a BPMN process.
The main differences between them are:
1. Scope: Execution listeners are associated with process executions, while task listeners are associated with 
   individual tasks.
2. Triggers: Execution listeners can be triggered by a wider range of events like activity start, end, take, 
   and error events. Task listeners are triggered by task events like as task creation, assignment, completion, and 
   deletion.
3. Context: Execution listeners have access to the entire execution of the process, including process variables,
   process instance IDs, and process instance histories. Task listeners have access to a more limited context,  
   including task variables, task IDs, and task history.
4. Use cases: Execution listeners are typically used for more high-level process management tasks such as logging,  
   auditing, and error handling. Task listeners are typically used for more low-level task management tasks such as 
   task assignment, notifications, and form handling.
5. Precedence: Execution listeners have a higher precedence than task listeners.

### ProcessDefinitionKey, ProcessDefinitionId, ProcessInstanceId
* ProcessDefinitionKey: we set it in the Modeler under "ID" property (unique per a single deployment)
  * We can not have more than one ".bpmn" file with the same "Id" in the same project
* ProcessDefinitionId: generated automatically by the Camunda engine when a process is deployed, (globally unique 
  across camunda engine)
  * We can use ProcessDefKey to get ProcessDefId
* ProcessInstanceId: differ for each request
* TaskId: each task has a unique id that is never repeated with each request