package com.app.DailyStatus.repository;

import com.app.DailyStatus.model.Employee;
import com.app.DailyStatus.model.StatusUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusUpdateRepository extends JpaRepository<StatusUpdate, Long> {
    List<StatusUpdate> findByEmployee(Employee employee);
}
