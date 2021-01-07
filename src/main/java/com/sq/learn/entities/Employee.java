package com.sq.learn.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {

	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private BigDecimal sal;
	private BigDecimal comm;
	private int deptno;

	public Employee() {
	}
	
	public Employee(int empno, String ename, String job, int mgr, Date hiredate, BigDecimal sal, BigDecimal comm,
			int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	/**
	 * @return the empno
	 */
	public int getEmpno() {
		return empno;
	}

	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @return the mgr
	 */
	public int getMgr() {
		return mgr;
	}

	/**
	 * @return the hiredate
	 */
	public Date getHiredate() {
		return hiredate;
	}

	/**
	 * @return the sal
	 */
	public BigDecimal getSal() {
		return sal;
	}

	/**
	 * @return the comm
	 */
	public BigDecimal getComm() {
		return comm;
	}

	/**
	 * @return the deptno
	 */
	public int getDeptno() {
		return deptno;
	}

	/**
	 * @param empno the empno to set
	 */
	public void setEmpno(int empno) {
		this.empno = empno;
	}

	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @param mgr the mgr to set
	 */
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	/**
	 * @param hiredate the hiredate to set
	 */
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	/**
	 * @param sal the sal to set
	 */
	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	/**
	 * @param comm the comm to set
	 */
	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}

	/**
	 * @param deptno the deptno to set
	 */
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	

}
