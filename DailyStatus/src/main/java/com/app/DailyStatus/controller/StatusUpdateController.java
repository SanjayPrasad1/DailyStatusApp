//package com.app.DailyStatus.controller;
//
//import com.app.DailyStatus.model.Employee;
//import com.app.DailyStatus.model.StatusUpdate;
//import com.app.DailyStatus.service.EmployeeService;
//import com.app.DailyStatus.service.StatusUpdateService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/status")
//public class StatusUpdateController {
//    private final StatusUpdateService statusUpdateService;
//    private final EmployeeService employeeService;
//
//    public StatusUpdateController(StatusUpdateService statusUpdateService, EmployeeService employeeService) {
//        this.statusUpdateService = statusUpdateService;
//        this.employeeService = employeeService;
//    }
//
//    @PostMapping("/submit/{employeeId}")
//    public StatusUpdate submitStatus(@PathVariable Long employeeId, @RequestBody StatusUpdate statusUpdate) {
//        Optional<Employee> employeeOptional = employeeService.findById(employeeId);
//        if (employeeOptional.isPresent()) {
//            statusUpdate.setEmployee(employeeOptional.get());
//            return statusUpdateService.submitStatus(statusUpdate);
//        } else {
//            throw new RuntimeException("Employee not found with id: " + employeeId);
//        }
//    }
//
//    @GetMapping("/employee/{employeeId}")
//    public List<StatusUpdate> getStatusByEmployee(@PathVariable Long employeeId) {
//        Optional<Employee> employeeOptional = employeeService.findById(employeeId);
//        if (employeeOptional.isPresent()) {
//            return statusUpdateService.getStatusByEmployee(employeeOptional.get());
//        } else {
//            throw new RuntimeException("Employee not found with id: " + employeeId);
//        }
//    }
//    @GetMapping("/all")
//    public List<StatusUpdate> getAllStatuses(){
//        return statusUpdateService.getAllStatuses();
//    }
//}
//

package com.app.DailyStatus.controller;

import com.app.DailyStatus.model.Employee;
import com.app.DailyStatus.model.StatusUpdate;
import com.app.DailyStatus.service.EmployeeService;
import com.app.DailyStatus.service.StatusUpdateService;
//import com.app.DailyStatus.service.RAGQueryService; // Import the RAGQueryService
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/status")
public class StatusUpdateController {

    private final StatusUpdateService statusUpdateService;
    private final EmployeeService employeeService;
//    private final RAGQueryService ragQueryService;  // Inject the RAGQueryService

    public StatusUpdateController(StatusUpdateService statusUpdateService, EmployeeService employeeService) {//RAGQueryService ragQueryService
        this.statusUpdateService = statusUpdateService;
        this.employeeService = employeeService;
//        this.ragQueryService = ragQueryService;
    }

    // Endpoint to submit the status update and query FastAPI for relevant statuses
    @PostMapping("/submit/{employeeId}")
    public StatusUpdate submitStatus(@PathVariable Long employeeId, @RequestBody StatusUpdate statusUpdate) throws JsonProcessingException {
        Optional<Employee> employeeOptional = employeeService.findById(employeeId);
        if (employeeOptional.isPresent()) {
            statusUpdate.setEmployee(employeeOptional.get());

            // Save the status update
            StatusUpdate savedStatus = statusUpdateService.submitStatus(statusUpdate);

            // Sample status list for testing
//            List<String> statuses = List.of("Worked on login module", "Fixed database bug", "Attended meeting");
//            String prompt = "login";  // Replace with dynamic input or a different logic to set the prompt
//
//            // Call FastAPI service for relevant status updates
//            String relevantStatus = ragQueryService.getRelevantStatus(prompt, statuses);
//
//            // You can process or return the relevant status as part of the response, if needed
//            savedStatus.setStatusText("Relevant Status: " + relevantStatus);  // Optionally update the status with the relevant result

            return savedStatus;
        } else {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }
    }

    // Endpoint to get the status updates of a specific employee
    @GetMapping("/employee/{employeeId}")
    public List<StatusUpdate> getStatusByEmployee(@PathVariable Long employeeId) {
        Optional<Employee> employeeOptional = employeeService.findById(employeeId);
        if (employeeOptional.isPresent()) {
            return statusUpdateService.getStatusByEmployee(employeeOptional.get());
        } else {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }
    }

    // Endpoint to get all status updates
    @GetMapping("/all")
    public List<StatusUpdate> getAllStatuses() {
        return statusUpdateService.getAllStatuses();
    }
}
