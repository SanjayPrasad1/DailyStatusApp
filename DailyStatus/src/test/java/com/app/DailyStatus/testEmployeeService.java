//package com.app.DailyStatus;
//
//import com.app.DailyStatus.model.Employee;
//import com.app.DailyStatus.repository.EmployeeRepository;
//import com.app.DailyStatus.service.EmployeeService;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.testng.Assert.assertTrue;
//import static org.testng.AssertJUnit.assertEquals;
//
//public class testEmployeeService {
//    @InjectMocks
//    private EmployeeService employeeService;
//    @Mock
//    private EmployeeRepository employeeRepository;
//
//    @BeforeMethod
//    public void setUp(){
//        MockitoAnnotations.openMocks(this);
//    }
//    @Test
//    public void testRegisterEmployee(){
//        Employee employee = new Employee();
//        employee.setName("Sanjay Prasad");
//        employee.setEmail("sanjay.prasad@example.com");
//        employee.setRole(Employee.Role.EMPLOYEE);
//
//        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
//
//        Employee savedEmployee = employeeService.registerEmployee(employee);
//        System.out.println(savedEmployee);
//        Assert.assertNotNull(savedEmployee);
//        assertEquals(savedEmployee.getName(),"Sanjay Prasad");
//        assertEquals(savedEmployee.getEmail(),"sanjay.prasad@example.com");
//
//        verify(employeeRepository,times(1)).save(employee);
//    }
//    @Test
//    public void testFindByEmail(){
//        Employee employee = new Employee();
//        employee.setName("Sanjay");
//        employee.setEmail("sanjay.prasad@example.com");
//
//        when(employeeRepository.findByEmail("sanjay.prasad@example.com")).thenReturn(Optional.of(employee));
//
//        Optional<Employee> foundEmployee = employeeService.findByEmail("sanjay.prasad@example.com");
//
//        assertTrue(foundEmployee.isPresent());
//        assertEquals(foundEmployee.get().getName(), "Sanjay");
//    }
//
//}
