package com.app.DailyStatus.repository;

import com.app.DailyStatus.model.Employee;
import com.app.DailyStatus.model.StatusUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StatusUpdateRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(StatusUpdate status){
        String sql = "insert into daily_status (employee_id, status_text, created_at) values (?,?,?)";
        return jdbcTemplate.update(sql,
                status.getEmployee().getId(),
                status.getStatusText(),
                status.getCreatedAt());
    }

    public List<StatusUpdate> getStatusByEmployeeId(Long employeeId){
      String sql = "select s.id, s.status_text, s.created_at, e.id AS employee_id, e.name from daily_status s join employee e on s.employee_id = e.id where s.employee_id = ?";
      return jdbcTemplate.query(sql, new Object[]{employeeId},new StatusUpdateRowMapper());
    }

    public void deleteStatus(Long employeeId){
        String sql = "delete from daily_status where employee_id=?";
        jdbcTemplate.update(sql, employeeId);
        System.out.println("Deleted status for employeeId: "+employeeId);
    }

    static class StatusUpdateRowMapper implements RowMapper<StatusUpdate>{
        @Override
        public StatusUpdate mapRow(ResultSet rs, int rowNum) throws SQLException{
            StatusUpdate statusUpdate = new StatusUpdate();
            statusUpdate.setId(rs.getLong("id"));
            statusUpdate.setStatusText(rs.getString("status_text"));
            statusUpdate.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

            Employee emp = new Employee();
            emp.setId(rs.getInt("employee_id"));
            emp.setName(rs.getString("name"));
            statusUpdate.setEmployee(emp);
            return statusUpdate;

        }
    }
}

