package com.app.DailyStatus.service;

import com.app.DailyStatus.model.Employee;
import com.app.DailyStatus.model.StatusUpdate;
import com.app.DailyStatus.repository.StatusUpdateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusUpdateService {
    private final StatusUpdateRepository statusUpdateRepository;

    public StatusUpdateService(StatusUpdateRepository statusUpdateRepository) {
        this.statusUpdateRepository = statusUpdateRepository;
    }

    public StatusUpdate submitStatus(StatusUpdate statusUpdate){
        return statusUpdateRepository.save(statusUpdate);
    }
    public List<StatusUpdate> getStatusByEmployee(Employee employee){
        return statusUpdateRepository.findByEmployee(employee);
    }
    public List<StatusUpdate> getAllStatuses(){
        return statusUpdateRepository.findAll();
    }
}
