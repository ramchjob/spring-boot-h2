package com.sq.learn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sq.learn.entities.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class DeptRowMapper implements RowMapper<Employee> {
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

			Employee emp = new Employee(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"),
					rs.getInt("mgr"), rs.getDate("hiredate"), rs.getBigDecimal("sal"), rs.getBigDecimal("comm"),
					rs.getInt("deptno"));
			return emp;
		}

	}

	public List<Employee> getAllEmployees() {

		BeanPropertyRowMapper<Employee> empRowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		empRowMapper.setPrimitivesDefaultedForNullValue(true);
		return jdbcTemplate.query("SELECT * FROM EMPLOYEE", empRowMapper);

	}

	public Employee getByEmptNo(long empno) {
		return jdbcTemplate.queryForObject("select * from employee where empno = ? ", new Object[] { empno },
				new DeptRowMapper());
	}

	public int delEmpById(long empno) {
		return jdbcTemplate.update("delete from emp where empno=?", empno);
	}

}
