package com.app.DailyStatus.service;

import com.app.DailyStatus.model.StatusUpdate;
import com.app.DailyStatus.repository.StatusUpdateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusUpdateService {
    private final StatusUpdateRepository statusUpdateRepository;

    public StatusUpdateService(StatusUpdateRepository statusUpdateRepository) {
        this.statusUpdateRepository = statusUpdateRepository;
    }

    public void submitStatus(StatusUpdate statusUpdate){
        statusUpdateRepository.save(statusUpdate);
    }
    public List<StatusUpdate> getStatusByEmployee(Long id){
         return statusUpdateRepository.getStatusByEmployeeId(id);
    }

    public void deleteStatus (Long employeeId){
        statusUpdateRepository.deleteStatus(employeeId);
    }
}
