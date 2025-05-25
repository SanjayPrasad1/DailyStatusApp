package com.app.DailyStatus.controller;

import com.app.DailyStatus.model.StatusUpdate;
import com.app.DailyStatus.service.EmployeeService;
import com.app.DailyStatus.service.StatusUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusUpdateController {

    private final StatusUpdateService statusUpdateService;
    private final EmployeeService employeeService;

    @Autowired
    public StatusUpdateController(StatusUpdateService statusUpdateService, EmployeeService employeeService) {
        this.statusUpdateService = statusUpdateService;
        this.employeeService = employeeService;
    }

    @PostMapping("/submitStatus")
    public ResponseEntity<String> submitStatus(@RequestBody StatusUpdate statusUpdate) {
        statusUpdateService.submitStatus(statusUpdate);
        return ResponseEntity.ok("Status Submitted: ");
    }

    @GetMapping("by-employeeId/{employeeId}")
    public ResponseEntity<List<StatusUpdate>> getStatusByEmployee(@PathVariable Long employeeId) {
        List<StatusUpdate> statusList = statusUpdateService.getStatusByEmployee(employeeId);
        if (statusList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<StatusUpdate> response = statusList.stream()
                .map(statusUpdate -> new StatusUpdate(statusUpdate.getStatusText(),
                        statusUpdate.getCreatedAt(),
                        statusUpdate.getEmployee().getName())).toList();

        return ResponseEntity.ok(statusList);
    }
    @DeleteMapping("/deleteByEmployee/{employeeId}")
    public ResponseEntity<String> deleteStatusByEmployeeId(@PathVariable Long employeeId) {
        statusUpdateService.deleteStatus(employeeId);
        return ResponseEntity.ok("Deleted status for employeeId: " + employeeId);
    }
}
