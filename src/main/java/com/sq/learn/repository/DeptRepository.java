package com.sq.learn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sq.learn.entities.Dept;

@Repository
public class DeptRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class DeptRowMapper implements RowMapper<Dept> {
		public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
			Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
			return dept;
		}

	}


	public List<Dept> getAllDept() {
		return jdbcTemplate.query("SELECT * FROM dept", new DeptRowMapper());
	}

	public Dept getByDeptNo(long deptno) {
		return jdbcTemplate.queryForObject("select * from dept where deptno = ? ", new Object[] { deptno },new DeptRowMapper());
	}

	public int delDeptById(long deptno) {
		return jdbcTemplate.update("delete from dept where deptno=?", deptno);
	}

	public int addDept(Dept dept) {
		return jdbcTemplate.update("insert into dept values(?,  ?, ?)",new Object[] {dept.getDeptno(), dept.getDname(), dept.getLoc() });
	}

	public int update(Dept dept) {
		return jdbcTemplate.update("update dept " + " set dname = ?, loc = ? " + " where deptno = ?",
				new Object[] { dept.getDname(), dept.getLoc(), dept.getDeptno() });
	}
		
}







