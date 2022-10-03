--create database SDAProject1
--go 
use SDAProject1
--DROP TABLE [user]

create table [user](       
	u_id int IDENTITY(1,1) PRIMARY KEY,
	[name] nvarchar(20),       
	cnic nvarchar(19),
	[password] nvarchar(20),
	fatherName nvarchar(25) not null,
	dob date not null,
	gender char not null,
	mobile nvarchar(12) check ( mobile like '03__-%'),
	city nvarchar(10)
)

create table admin(       
  admin_id int IDENTITY(1,1) PRIMARY KEY
 )
  

create table course(
	c_id int primary key,
	name nvarchar(40) unique,
	creditHours int
)

create table section(
	sec_id int primary key,
	name nvarchar(40) unique
)

create table course_sec(
	cs_id int IDENTITY(1,1) PRIMARY KEY,
	c_id int foreign key references  course(c_id),
	sec_id int foreign key references section(sec_id),
	std_count int check (std_count<=10 and std_count>=0)
)

create table student(
  std_id int unique foreign key references  [user](u_id),
  rollno int unique,
  curr_sem int,
  primary key (std_id)
)

create table teacher(
  t_id int unique foreign key references  [user](u_id),
  primary key (t_id)
)

create table Attandence(
	c_id int foreign key references course(c_id),
	std_id int foreign key references student(std_id), 
	[status] char(1) DEFAULT 'A' check ([status]='A' or [status]='P'),
	[date] date not null
)

create table t_reg(
	t_reg_id int IDENTITY(1,1) PRIMARY KEY,
	t_id int foreign key references  teacher(t_id),
	cs_id int foreign key references  course_sec(cs_id)
)

create table std_reg(
	std_reg_id int IDENTITY(1,1) PRIMARY KEY,
	sem int,
	std_id int foreign key references  student(std_id),
	cs_id int foreign key references  course_sec(cs_id),
	cs_grade char(1) DEFAULT 'N',
	grade float
)
--drop table evaluations
create table evaluations(	
	e_id int IDENTITY(1,1) PRIMARY KEY,
	t_id int foreign key references teacher(t_id),
	cs_id int foreign key references  course_sec(cs_id),
	[type] varchar(20),
	total int,
	weightage int
)
--drop table marks
create table marks(
	m_id int IDENTITY(1,1) PRIMARY KEY,
	e_id int foreign key references evaluations(e_id),
	std_id int foreign key references student(std_id),
	obtained_marks int,
	obtained_weightage float
)

create table sgpa(
	sgpa_id int IDENTITY(1,1) PRIMARY KEY,
	std_id int foreign key references  student(std_id),
	sem int,
	sgpa char(1) DEFAULT 'N'	
)

create table transcript(
	trans_id int IDENTITY(1,1) PRIMARY KEY,
	std_id int foreign key references  student(std_id),
	sem int,
	cgpa char(1) DEFAULT 'N'	
)

Select * from [user]

INSERT INTO [user] Values ('Muhammad Sufian', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO student values (1,1001,1);

INSERT INTO [user] Values ('Muhammad Asghar', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO student values (2,1002,2);

INSERT INTO [user] Values ('Ali Akbar', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO student values (3,1003,2);

INSERT INTO [user] Values ('Hamza Ali', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO student values (4,1004,2);

INSERT INTO [user] Values ('Awais Ali', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO student values (5,1005,2);

INSERT INTO [user] Values ('Ali faiz', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO student values (6,1006,2);

INSERT INTO [user] Values ('Faizan ALi', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO student values (7,1007,7);

INSERT INTO [user] Values ('Ali Rehman', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO student values (8,1008,2);

INSERT INTO [user] Values ('Qutab Akbar', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO student values (9,1009,2);

INSERT INTO [user] Values ('Mehmood Sahb', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO student values (10,1010,2);

INSERT INTO [user] Values ('Khizer ALi', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO student values (11,1011,2);

INSERT INTO [user] Values ('Farooq ALi', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO student values (12,1012,2);

-------------------------------------------------------------------------------------------------------------------------------------


INSERT INTO [user] Values ('Ibrahim Nadir', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO teacher values (13);

INSERT INTO [user] Values ('Adnan Malik', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO teacher values (14);

INSERT INTO [user] Values ('Abdul Hafeez', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO teacher values (15);

INSERT INTO [user] Values ('Amir Raheem', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
INSERT INTO teacher values (16);

INSERT INTO [user] Values ('Abeeda Akram', '2313491849194','12345','Muhammad Ahmad',getdate(),'F', '0321-6961456','Okara')
INSERT INTO teacher values (17);

-----------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO course Values (11,'SDA',3)
INSERT INTO course Values (12,'OOP',3)
INSERT INTO course Values (13,'Algorithms',3)
INSERT INTO course Values (14,'LA',3)
INSERT INTO course Values (15,'Cal-1',3)
INSERT INTO course Values (16,'Programming Fundamentals',3)
INSERT INTO course Values (17,'Database',3)
INSERT INTO course Values (18,'OS',3)

select *from student

-------------------------------------------------------------------------------------------------------------------------------------------


INSERT INTO Section Values (1,'A')
INSERT INTO Section Values (2,'B')
INSERT INTO Section Values (3,'C')


-------------------------------------------------------------------------------------------------------------------------------------------

--1
INSERT INTO course_sec Values (11,1,0)
INSERT INTO course_sec Values (11,2,0)
INSERT INTO course_sec Values (11,3,0)

--3
INSERT INTO course_sec Values (12,1,0)
INSERT INTO course_sec Values (12,2,0)
INSERT INTO course_sec Values (12,3,0)

--7
INSERT INTO course_sec Values (13,1,0)
INSERT INTO course_sec Values (13,2,0)
INSERT INTO course_sec Values (13,3,0)

--10
INSERT INTO course_sec Values (14,1,0)
INSERT INTO course_sec Values (14,2,0)
INSERT INTO course_sec Values (14,3,0)

--13
INSERT INTO course_sec Values (15,1,0)
INSERT INTO course_sec Values (15,2,0)
INSERT INTO course_sec Values (15,3,0)

--16
INSERT INTO course_sec Values (16,1,0)
INSERT INTO course_sec Values (16,2,0)
INSERT INTO course_sec Values (16,3,0)

--19
INSERT INTO course_sec Values (17,1,0)
INSERT INTO course_sec Values (17,2,0)
INSERT INTO course_sec Values (17,3,0)

----22
INSERT INTO course_sec Values (18,1,0)
INSERT INTO course_sec Values (18,2,0)
INSERT INTO course_sec Values (18,3,0)


---------------------------------------------------------------------------------------------------------------------------------------------
Select * from [user]
insert into t_reg values (13,1)
insert into t_reg values (13,2)
insert into t_reg values (13,3)

insert into t_reg values (14,1)
insert into t_reg values (14,2)
insert into t_reg values (14,3)

insert into t_reg values (15,1)
insert into t_reg values (15,2)
insert into t_reg values (15,3)

insert into t_reg values (16,1)
insert into t_reg values (16,2)
insert into t_reg values (16,3)

insert into t_reg values (17,1)
insert into t_reg values (17,2)
insert into t_reg values (17,3)

insert into t_reg values (18,1)
insert into t_reg values (18,2)
insert into t_reg values (18,3)



----------------------------------------------------------------------------------------------------------------------------------------------
insert into std_reg values (1,1,1,'N',0)
insert into std_reg values (2,10,1,'N',0)
insert into std_reg values (3,1,1,'N',0)
insert into std_reg values (4,4,1,'N',0)
insert into std_reg values (5,1,1,'N',0)
insert into std_reg values (6,1,1,'N',0)
insert into std_reg values (7,2,1,'N',0)
insert into std_reg values (8,1,1,'N',0)
insert into std_reg values (9,9,1,'N',0)
insert into std_reg values (10,6,1,'N',0)
insert into std_reg values (11,8,1,'N',0)
insert into std_reg values (12,7,1,'N',0)

Select * from std_reg

--add_course
--withdraw_course 
--add_attendance
--add_evaluation
--calculate-cs-grade
--calculate-sgpa
--calculate cgpa

---------------------------------------------------------------------------------------------------------------------------------------------------------
drop proc  add_attendance 
create proc add_attendance                                                 --this procedure adds a particular students attendance----rr------------------
@c_id int,@std_id int,@status char(1),@out int OUTPUT
as 
begin 
	if EXISTS ( select * from Attandence 
	where c_id = @c_id AND [date] = GETDATE() AND std_id= @std_id ) 
			begin 
				set @out = 0
				 
			end
	else 
	begin
		insert into Attandence values (@c_id,@std_id,@status,GETDATE())
		set @out =1
	end
end


select * from Attandence
declare @o int
	exec add_attendance 11,3,'P',@o
select @o

drop proc add_evaluation
create proc add_evaluation
@t_id int,@cs_id int,@type varchar(20),@total int,@weightage int,@out int OUTPUT

as
begin
	if (@weightage>100)
	begin
		set @out=0
	end
	else if EXISTS(Select * from t_reg where t_id=@t_id and cs_id=@cs_id)
	begin
		insert into evaluations values (@t_id,@cs_id,@type,@total,@weightage)
		set @out = 1
	end
	else
	begin
		set @out=0
	end
end
select * from t_reg
select * from evaluations
declare @o int
	exec add_evaluation 13,1,'mid',135,50,@o
select @o

drop proc add_marks
create proc add_marks
@e_id int,@std_id int,@marks int,@out int OUTPUT

as
begin
		declare @total float
		declare @w float
		set @w = (Select weightage from evaluations where @e_id=e_id)
		set @total = (Select total from evaluations where @e_id=e_id)
		
		set @out=1
		declare @weightage float 
		set @weightage=(@marks/@total)*@w
		insert into marks values (@e_id,@std_id,@marks,@weightage)
	
end
drop proc calculate_sub_gpa
create proc calculate_sub_gpa
@sem int,@std_id int,@cs_id int
as
begin
	declare @sum float
	declare @grade float
	declare @cs_grade char(1)
	set @sum = (select Sum(obtained_weightage) from marks join evaluations on marks.e_id=evaluations.e_id where marks.std_id=@std_id and evaluations.cs_id=@cs_id)

	if(@sum>=90)
	begin
		set @grade = 4.00
		set @cs_grade = 'A+'
	end

	else if(@sum<=89 AND @sum>=86)
	begin
		set @grade = 4.00
		set @cs_grade = 'A'
	end


	else if(@sum<=85 AND @sum>=82)
	begin
		set @grade = 3.67
		set @cs_grade = 'A-'
	end

	
	else if(@sum<=81 AND @sum>=78)
	begin
		set @grade = 3.33
		set @cs_grade = 'B+'
	end

	
	else if(@sum<=77 AND @sum>=74)
	begin
		set @grade = 3.00
		set @cs_grade = 'B'
	end

	
	else if(@sum<=73 AND @sum>=70)
	begin
		set @grade = 2.67
		set @cs_grade = 'B-'
	end

	
	else if(@sum<=69 AND @sum>=66)
	begin
		set @grade = 2.33
		set @cs_grade = 'C+'
	end

	
	else if(@sum<=65 AND @sum>=62)
	begin
		set @grade = 2.00
		set @cs_grade = 'C'
	end

	
	else if(@sum<=61 AND @sum>=58)
	begin
		set @grade = 1.67
		set @cs_grade = 'C-'
	end

	
	else if(@sum<=57 AND @sum>=54)
	begin
		set @grade = 1.33
		set @cs_grade = 'D+'
	end

	
	else if(@sum<=53 AND @sum>=50)
	begin
		set @grade = 1.00
		set @cs_grade = 'D'
	end

	else 
	begin
		set @grade = 0.00
		set @cs_grade = 'F'
	end
	
	UPDATE std_reg SET grade=@grade, cs_grade=@cs_grade WHERE std_reg.std_id=@std_id and sem=@sem and cs_id=@cs_id

end

Select * from t_reg

Select * from course_sec
Select * from student
Select* from evaluations
select * from marks
declare @o int
	exec add_marks 3,1,100,@o
select @o

Select* from evaluations

select * from marks
exec calculate_sub_gpa 1,1,1

INSERT INTO [user] Values ('Muhammad Sufian', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '0321-6961456','Okara')
go

drop procedure user_login
create procedure user_login
@id int,@password nvarchar(20),@output int out
as begin

if exists (select* from [user] where u_id=@id and @password= [password])
Begin

if exists(select* from [student] where student.std_id=@id)
begin
set @output=1

return
end

else if exists(select* from [teacher] where teacher.t_id=@id)
begin
set @output=2

return
end

else if exists(select* from [admin] where admin.admin_id=@id)
begin
set @output=3

return
end


End
ELSE
begin
set @output=-1

return
end


end

Select* from [user]
Select* from student
Select* from teacher

declare @o int
	exec user_login 19,'12345',@o out
select @o as o