//package com.app.DailyStatus.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "status_updates")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class StatusUpdate {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "employee_id")
//    private Employee employee;
//
//    @Column(nullable = false,columnDefinition = "TEXT")
//    private String statusText;
//
//    private LocalDateTime submittedAt = LocalDateTime.now();
//
//}












package com.app.DailyStatus.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class StatusUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statusText;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Constructors
    public StatusUpdate() {}

    public StatusUpdate(String statusText, LocalDateTime createdAt, Employee employee) {
        this.statusText = statusText;
        this.createdAt = createdAt;
        this.employee = employee;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
