create table dept(  
  deptno     int,  
  dname      varchar(14),  
  loc        varchar(13),  
  constraint pk_dept primary key (deptno)  
);

create table employee(  
  empno    int,  
  ename    varchar(10),  
  job      varchar(9),  
  mgr      int,  
  hiredate date,  
  sal      decimal(7,2),  
  comm     decimal(7,2),  
  deptno   decimal(2,0),  
  constraint pk_emp primary key (empno),  
  constraint fk_deptno foreign key (deptno) references dept (deptno)  
);