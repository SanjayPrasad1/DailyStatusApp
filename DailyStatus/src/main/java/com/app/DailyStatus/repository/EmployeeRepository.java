package com.app.DailyStatus.repository;

import com.app.DailyStatus.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class EmployeeRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Employee emp){
        String sql = "insert into employee (name, email, role) values (?,?,?)";
        return jdbcTemplate.update(sql,emp.getName(),emp.getEmail(),emp.getRole());
    }

    public Optional<Employee> findByEmail(String email){
        String sql = "select * from employee where email = ? ";
        try{
            Employee emp = jdbcTemplate.queryForObject(sql, new Object[]{email}, new EmployeeRowMapper());
                    return Optional.ofNullable(emp);
        } catch (Exception e){
            return Optional.empty();
        }
    }

    public Optional<Employee> findById(int id){
        String sql = "select * from employee where id= ? ";
        try{
            Employee emp= jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
            return Optional.ofNullable(emp);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    public void deleteEmployee(int id){
        String sql = "delete from employee where id = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("Employee deleted for id: "+id);
    }

    static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setEmail(rs.getString("email"));
            emp.setRole(rs.getString("role"));
            return emp;
        }
    }

}


