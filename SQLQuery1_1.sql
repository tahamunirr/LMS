drop database SDAProject1
create database SDAProject1
go 
use master
use SDAProject1


create table [user](       
	u_id int IDENTITY(1,1) PRIMARY KEY,
	[name] nvarchar(20),       
	cnic nvarchar(19),
	[password] nvarchar(20),
	fatherName nvarchar(25) not null,
	dob date not null,
	gender char not null,
	mobile nvarchar(12),
	city nvarchar(10)
)

--drop table admin

create table admin(       
  admin_id int foreign key references [user](u_id),
 )
  

create table course(
	c_id int IDENTITY(1,1) primary key,
	name nvarchar(40) unique,
	sem int,
	creditHours int
)


create table section(
	sec_id int IDENTITY(1,1) primary key,
	name nvarchar(40) unique
)


create table sem
(
  sem_id int IDENTITY(1,1) PRIMARY KEY,
  name varchar(20)
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


create table std_sem
(
  std_sem_id int IDENTITY(1,1) PRIMARY KEY,
  sem_id int foreign key references sem(sem_id),
  curr_sem int,
  std_id int foreign key references student(std_id),
  sgpa float,
  credit_er int
)

create table course_sec(
	cs_id int IDENTITY(1,1) PRIMARY KEY,
	c_id int foreign key references  course(c_id),
	sec_id int foreign key references section(sec_id),
	sem_id int foreign key references sem(sem_id),
	std_count int check (std_count<=3 and std_count>=0)
)



create table application
(
	app_id int IDENTITY(1,1) PRIMARY KEY,
	std_id int foreign key references  [user](u_id),
	cs_id int foreign key references course_sec(cs_id),
	sem_id int foreign key references sem(sem_id)
)

--drop table Attandence

create table Attandence(
    a_id int IDENTITY(1,1) Primary key,
	cs_id int foreign key references course_sec(cs_id),
	std_id int foreign key references student(std_id), 
	[status] char(1) DEFAULT 'A',
	[date] date not null
)

create table t_reg(
	t_reg_id int IDENTITY(1,1) PRIMARY KEY,
	t_id int foreign key references  teacher(t_id),
	sem_id int foreign key references sem(sem_id),
	cs_id int foreign key references  course_sec(cs_id)
)


create table std_reg(
	curr_sem int,
	std_id int foreign key references  student(std_id),
	cs_id int foreign key references  course_sec(cs_id),
	sem_id int foreign key references sem(sem_id),
	cs_grade char(1) DEFAULT 'N',
	grade float,
	primary key (cs_id,std_id)
)


--drop table evaluations


create table evaluations(	
	e_id int IDENTITY(1,1) PRIMARY KEY,
	t_id int foreign key references teacher(t_id),
	cs_id int foreign key references  course_sec(cs_id),
	sem_id int foreign key references sem(sem_id),
	[type] varchar(20),
	total int,
	weightage int
)

--drop table marks

create table marks(
	e_id int foreign key references evaluations(e_id),
	std_id int foreign key references student(std_id),
	obtained_marks int,
	obtained_weightage float,
	primary key (e_id,std_id)
)


create table transcript(
	trans_id int IDENTITY(1,1) PRIMARY KEY,
	std_id int foreign key references  student(std_id),
	sem int,
	cgpa float	
)

SELECT*from course
SELECT*from section
SELECT*from course_sec
SELECT*from std_reg
SELECT*from student
SELECT*from evaluations
SELECT*from marks
SELECT*from [user]




--add_course
--withdraw_course 
--add_attendance
--add_evaluation
--calculate-cs-grade
--calculate-sgpa
--calculate cgpa






------------------------------Reg--------------------------------------

--select std_count from course_sec where course_sec.cs_id =5

--drop procedure std_regis
go
create procedure std_regis
  @student_id int,@course_id int,@out int out
as begin
declare @curr_semester int,@sem int


if ((select std_count from course_sec where course_sec.cs_id = @course_id) = 3)
begin
set @out= -1
end
else
begin

begin
set @curr_semester = (select student.curr_sem from student where student.std_id=@student_id)
set @sem=(select top(1) sem.sem_id from sem order by sem.sem_id desc)
begin
Update course_sec set std_count= (select std_count from course_sec where course_sec.cs_id = @course_id)+1  where course_sec.cs_id = @course_id and course_sec.sem_id=@sem
end
insert into std_reg values (@curr_semester,@student_id,@course_id,@sem,'N',0.0)
end
end

return @out

end

--declare @o int
--exec std_regis 1,5,@o out
--select @o
------------------------------------------------------------END-----------------------------------------------------------------







--------------------------------------------------------DROP reg------------------------------------------------------------

go
create procedure drop_reg
@std_id int,@cs_id int
as begin
declare @sem int
begin
delete from std_reg where std_id=@std_id and cs_id=@cs_id
end

set @sem=(select top(1) sem.sem_id from sem order by sem.sem_id desc)
begin
Update course_sec set std_count= (select std_count from course_sec where course_sec.cs_id = @cs_id)-1  where course_sec.cs_id = @cs_id and course_sec.sem_id=@sem
end

end


--------------------------------------------------------------------END----------------------------------------------------------------

--------------------------------------------------------------CALCULATE CGPA------------------------------------------------------------

go 
create procedure cal_cgpa
@std_id int
as begin
declare  @totalgpafloat float, @totalcredit float ,@curr_sem int
begin
set @totalgpafloat =(select sum(std_sem.sgpa * std_sem.credit_er) from std_sem where std_sem.std_id=@std_id)
end

begin 
set @curr_sem=(select student.curr_sem from student where student.std_id=@std_id)
end

begin
set @totalcredit =(select sum(std_sem.credit_er) from std_sem where std_sem.std_id=@std_id)
end


begin

update transcript Set cgpa = @totalgpafloat/@totalcredit where std_id=@std_id
update transcript Set sem = @curr_sem where std_id=@std_id
end

end 

-------------------------------------------------------------------------------------------


----------------------------------------------------------USER_LOGIN---------------------------------------------
go
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
-------------------------------------------------------------------------------------------------------------


---------------------------------------------------------------------------------------------------------------------------------------------------------
--drop proc  add_attendance
Select*from Attandence
go
create proc add_attendance                                                 --this procedure adds a particular students attendance----rr------------------
@cs_id int,@std_id int,@status char(1),@out int OUTPUT
as 
begin 
	if EXISTS ( select * from Attandence 
	where cs_id = @cs_id AND [date] = GETDATE() AND std_id= @std_id ) 
			begin 
				set @out = 0
				 
			end
	else 
	begin
		insert into Attandence values (@cs_id,@std_id,@status,GETDATE())
		set @out =1
	end
end
-------------------------------------------------------------------------------------------------------------------------------------------------------------

declare @o int
	exec add_attendance 11,3,'P',@o
select @o

-------------------------------------------------------------------------------------------------------------------------------------------------------------
Select*from evaluations
go
create proc add_evaluation
@t_id int,@cs_id int,@type varchar(20),@total int,@weightage int,@out int OUTPUT

as
begin
	declare @sem int
	if (@weightage>100)
	begin
		set @out=0
	end
	else if EXISTS(Select * from t_reg where t_id=@t_id and cs_id=@cs_id)
	begin
		set @sem=(select top(1) sem.sem_id from sem order by sem.sem_id desc)
		insert into evaluations values (@t_id,@cs_id,@sem,@type,@total,@weightage)
		set @out = 1
	end
	else
	begin
		set @out=0
	end
end
-----------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------------------------------------------------------------------------------

go
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

-----------------------------------------------------------------------------------------------------------------------------



-----------------------------------------------------------------------------------------------------------------------------
go
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
	
	UPDATE std_reg SET grade=@grade, cs_grade=@cs_grade WHERE std_reg.std_id=@std_id and curr_sem=@sem and cs_id=@cs_id

end

-------------------------------------------------------------------------------------------------------------------------------

create procedure user_view
	@id int
as begin

if exists (select* from [user] where u_id=@id)
Begin

if exists(select* from [student] where student.std_id=@id)
begin

	select* from [user] join student on [user].u_id=student.std_id where student.std_id=@id

end

else if exists(select* from teacher where teacher.t_id=@id)
begin
	
	select* from [user] join teacher on [user].u_id= teacher.t_id where  teacher.t_id=@id

end

else if exists(select* from admin where admin.admin_id=@id)
begin
	
	select* from [user] join admin on [user].u_id= admin.admin_id where admin.admin_id=@id

end

else 
begin
	
	select -1

end

End
end 

exec view_course_std 1

-------------------------------------------------------------------------------------------------
create procedure view_course_std
	@id int
as begin

if exists (select* from [user] where u_id=@id)
Begin
declare @sem int
if exists(select* from [student] where student.std_id=@id)
begin
	set @sem=(select top(1) sem.sem_id from sem order by sem.sem_id desc)
	select course.name as course,section.name as section from student 
	join std_reg on student.std_id=std_reg.std_id 
	join course_sec on std_reg.cs_id=course_sec.cs_id 
	join section on section.sec_id=course_sec.sec_id 
	join course on course_sec.c_id=course.c_id 
	where student.std_id=@id and @sem=std_reg.sem_id

end

else 
begin
	
	select -1

end

End
end 


-------------------------------------------------------------------------------------------------

exec view_course_std 3
Select*from std_reg
--drop procedure view_course_attendence
--create procedure view_course_attendence
--	@id int
--as begin

--if exists (select* from [user] where u_id=@id)
--Begin

--if exists(select* from [student] where student.std_id=@id)
--begin

--	select course.name as course,section.name as section,Attandence.date,Attandence.status from student 
--	join std_reg on student.std_id=std_reg.std_id 
--	join course_sec on std_reg.cs_id=course_sec.cs_id 
--	join section on section.sec_id=course_sec.sec_id 
--	join course on course_sec.c_id=course.c_id 
--	join Attandence on Attandence.cs_id=course.c_id
--	where student.std_id=@id

--end

--else 
--begin
	
--	select -1

--end

--End
--end 

---------------------------------------------------------------------------------

--------------------------------------------------------------------------------------
--exec view_course_attendence 1

--drop procedure view_marks
--create procedure view_marks
--	@id int
--as begin

--if exists (select* from [user] where u_id=@id)
--Begin

--if exists(select* from [student] where student.std_id=@id)
--begin

--	select course.name course, section.name sec, evaluations.type, evaluations.total, marks.obtained_marks,
--	evaluations.weightage,marks.obtained_weightage
--	from student 
--	join std_reg on student.std_id=std_reg.std_id 
--	join course_sec on std_reg.cs_id=course_sec.cs_id 
--	join section on section.sec_id=course_sec.sec_id 
--	join course on course_sec.c_id=course.c_id 
--	join evaluations on evaluations.cs_id=course_sec.cs_id
--	join marks on evaluations.e_id=marks.e_id
--	where student.std_id=@id

--end

--else 
--begin
	
--	select -1

--end

--End
--end 
--exec view_marks 1

select * from std_reg

------------------------------------------------------------------------------



-------------------------------------------------------------------------------------------------

create proc get_stds
@t_id int, @cs_id int
as
Begin

select [user].u_id as id,[user].name as name, student.rollno as roll from t_reg join course_sec on t_reg.cs_id = course_sec.cs_id join course on course.c_id = course_sec.c_id 
join section on section.sec_id = course_sec.sec_id join std_reg on std_reg.cs_id = course_sec.cs_id 
join student on student.std_id= std_reg.std_id join [user] on [user].u_id = student.std_id 
where t_reg.t_id = @t_id and std_reg.sem_id = (select top(1) sem.sem_id from sem order by sem.sem_id desc)
and course_sec.cs_id = @cs_id

End




create proc get_sec
@t_id int
as
Begin

select course.name as course, section.name as section, course_sec.cs_id as cs from t_reg 
join course_sec on t_reg.cs_id = course_sec.cs_id 
join course on course.c_id = course_sec.c_id 
join section on section.sec_id = course_sec.sec_id 
where t_reg.t_id = @t_id and t_reg.sem_id= (select top(1) sem.sem_id from sem order by sem.sem_id desc)

End






-------------------------------------------------------------------------------------------------
create procedure off_courses
@id int
as
begin
if exists (select* from [user] where u_id=@id)
begin
if exists (select* from [student] where student.std_id=@id)
begin

select course_sec.cs_id as c_id, course.name as course, course.creditHours as crdt, section.name as section from course join student on course.sem = student.curr_sem join course_sec on course.c_id = course_sec.c_id join section on section.sec_id = course_sec.sec_id
where student.std_id =@id and sem_id =(select top(1) sem.sem_id from sem order by sem.sem_id desc)

end
end
end


-------------------------------------------------------------------------------------------------




---------------------------------------------------------------------------------------------------

create procedure view_course_attendence
    @id int,@cs_id int
as begin

if exists (select* from [user] where u_id=@id)
Begin

if exists(select* from [student] where student.std_id=@id)
begin

    select course_sec.cs_id, course.name as course,section.name as section,Attandence.date,Attandence.status 
    from student 
    join Attandence on Attandence.std_id = student.std_id
    join course_sec on Attandence.cs_id=course_sec.cs_id 
    join section on section.sec_id=course_sec.sec_id 
    join course on course_sec.c_id=course.c_id 
    where student.std_id=@id and course_sec.cs_id=@cs_id

end

else 
begin
    
    select -1

end

End
end 




create procedure view_marks
    @id int,@cs_id int
as begin

if exists (select* from [user] where u_id=@id)
Begin

if exists(select* from [student] where student.std_id=@id)
begin

    select course_sec.cs_id, course.name course, section.name sec, evaluations.type, evaluations.total, marks.obtained_marks,
    evaluations.weightage,marks.obtained_weightage
    from marks 
    join evaluations on evaluations.e_id=marks.e_id
    join course_sec on evaluations.cs_id=course_sec.cs_id 
    join section on section.sec_id=course_sec.sec_id 
    join course on course_sec.c_id=course.c_id 
    
    
    where marks.std_id=@id and course_sec.cs_id=@cs_id
end

else 
begin
    
    select -1

end

End
end 

-----------------------------------------------------------------------------------------------------




--------------------------------NEW-------------------------------------------------------------------
create proc GetEvaluations
@tid int, @cid int
as
Begin

Select * from evaluations where evaluations.t_id=@tid and evaluations.cs_id = @cid

End



--------------------------------NEW-------------------------------------------------------------------

create procedure addApllication
@st_id int , @cs_id int
as
Begin

if not exists (select * from std_reg where std_reg.std_id =@st_id and std_reg.cs_id = @cs_id)
begin
if not exists (select * from application where application.std_id =@st_id and application.cs_id = @cs_id)

begin

insert into application values (@st_id,@cs_id, (select top(1) sem.sem_id from sem order by sem.sem_id desc))
end

end

End


--------------------------------NEW-------------------------------------------------------------------


create procedure checkOpen
@st_id int, @out int out
as
Begin
if exists (select * from application where application.std_id = @st_id)
Begin----if

begin
declare @cs int, @sm int
end

begin
set @cs =( select application.cs_id from application where application.std_id =  @st_id)
end

begin
set @sm =( select std_count from course_sec where course_sec.cs_id = @cs)
end


if(@sm<3)
begin
set @out=1
end

end-----end if
else
begin
set @out =0
end

return @out

End

---------------------------------------------------------------------
go
create procedure returnStudents
as
Begin
select  std_id from student
End
---------------------------------------------------------------------


go
create procedure endSem
@name varchar(20)
as
Begin

begin
insert into sem values(@name)
end

begin
update course_sec set std_count=0
end

begin
update student set student.curr_sem=student.curr_sem+1
end

End

----------------------------------------------------------------------------
exec  view_course_std 1

create procedure view_course_std
    @id int
as begin

if exists (select* from [user] where u_id=@id)
Begin
declare @sem int
if exists(select* from [student] where student.std_id=@id)
begin
    set @sem=(select top(1) sem.sem_id from sem order by sem.sem_id desc)
    select course_sec.cs_id, course.name as course,section.name as section from student 
    join std_reg on student.std_id=std_reg.std_id 
    join course_sec on std_reg.cs_id=course_sec.cs_id 
    join section on section.sec_id=course_sec.sec_id 
    join course on course_sec.c_id=course.c_id 
    where student.std_id=@id and @sem=std_reg.sem_id

end

else 
begin
    
    select -1

end

End
end 

--------------------------------NEW-------------------------------------------------------------------
create procedure view_course_attendence
    @id int,@cs_id int
as begin

if exists (select* from [user] where u_id=@id)
Begin

if exists(select* from [student] where student.std_id=@id)
begin

    select course_sec.cs_id, course.name as course,section.name as section,Attandence.date,Attandence.status 
    from student 
    join Attandence on Attandence.std_id = student.std_id
    join course_sec on Attandence.cs_id=course_sec.cs_id 
    join section on section.sec_id=course_sec.sec_id 
    join course on course_sec.c_id=course.c_id 
    where student.std_id=@id and course_sec.cs_id=@cs_id

end

else 
begin

    select -1

end

End
end



--------------------------------NEW-------------------------------------------------------------------


create procedure view_transcript_std
    @id int,@sem int
as begin

if exists (select* from [user] where u_id=@id)
Begin
if exists(select* from [student] where student.std_id=@id)
begin
    select student.std_id, course_sec.cs_id,std_reg.curr_sem, course.name as course,section.name as section, 
    std_reg.grade, std_reg.cs_grade, std_sem.sgpa  from student 
    join std_reg on student.std_id=std_reg.std_id 
    join course_sec on std_reg.cs_id=course_sec.cs_id 
    join section on section.sec_id=course_sec.sec_id 
    join course on course_sec.c_id=course.c_id 
    join std_sem on std_sem.std_id = student.std_id
    where student.std_id=@id and std_reg.curr_sem=@sem


end

else 
begin
    
    select -1

end

End
end 


--------------------------------NEW-------------------------------------------------------------------

create procedure cal_sgpa
@semester int,@std_id int
as begin
declare @sgpa float, @totalgpafloat float, @totalcredit float,@curr_sem int
begin
set @curr_sem=(select student.curr_sem from student where student.std_id=@std_id)
end
begin
set @totalgpafloat =(select sum(std_reg.grade * course.creditHours) from std_reg join course_sec on course_sec.cs_id = std_reg.cs_id join course on course.c_id = course_sec.c_id where std_reg.curr_sem=@semester and std_reg.std_id=@std_id)
end

begin
set @totalcredit =(select sum(course.creditHours) from std_reg join course_sec on course_sec.cs_id = std_reg.cs_id join course on course.c_id = course_sec.c_id where std_reg.curr_sem=@semester and std_reg.std_id=@std_id)
end

begin
set @sgpa = @totalgpafloat/@totalcredit
end

begin
if @curr_sem > 0
begin
    insert into std_sem values (@semester ,@curr_sem, @std_id ,@sgpa, @totalcredit)  
end
else 
begin
    Select -1 
end
end 
end


--------------------------------NEW-------------------------------------------------------------------



create procedure sem_std
@id int,@sem int out
AS
BEGIN
    set @sem=(select student.curr_sem from student where student.std_id=@id)

	return @sem
END

--------------------------------NEW-------------------------------------------------------------------

create table regg
(
  r int default(0) primary key
);

--------------------------------NEW-------------------------------------------------------------------
create proc openreg
as
Begin
Update regg set r=1
End

--------------------------------NEW-------------------------------------------------------------------
create proc closereg
as
Begin
Update regg set r=0
End

--------------------------------NEW-------------------------------------------------------------------

create proc getreg
as
Begin
select * from regg
End

--------------------------------NEW-------------------------------------------------------------------
insert into regg values (0)



--------------------------------NEW-------------------------------------------------------------------
create proc getcgpa
@sid int
as
begin
if ((select transcript.cgpa from transcript where transcript.std_id=@sid)= 0)
begin
exec cal_cgpa @sid
end
select transcript.cgpa from transcript where transcript.std_id=@sid
end



-------------------------------------------------------- DATA ----------------------------------------------------------------

--update student set curr_sem =1

INSERT INTO [user] Values ('Sufian', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
INSERT INTO student values (1,1001,2);
INSERT INTO transcript values (1,1,0);

INSERT INTO [user] Values ('Asghar', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
INSERT INTO student values (2,1002,2);
INSERT INTO transcript values (2,1,0);
----------------------------------------------------------------------------------------------------------------------------
INSERT INTO [user] Values ('Akbar', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
INSERT INTO student values (3,1003,2);
INSERT INTO transcript values (3,1,0);

INSERT INTO [user] Values ('Ali', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
INSERT INTO student values (4,1004,2);
INSERT INTO transcript values (4,1,0);

INSERT INTO [user] Values ('Awais', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
INSERT INTO student values (5,1005,1);
INSERT INTO transcript values (5,1,0);

INSERT INTO [user] Values ('faiz', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
INSERT INTO student values (6,1006,1);
INSERT INTO transcript values (6,1,0);

INSERT INTO [user] Values ('Faizan', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
INSERT INTO student values (7,1007,1);
INSERT INTO transcript values (7,1,0);

INSERT INTO [user] Values ('Rehman', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
INSERT INTO student values (8,1008,1);
INSERT INTO transcript values (8,1,0);

--INSERT INTO [user] Values ('Qutab Akbar', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
--INSERT INTO student values (9,1009,2);

--INSERT INTO [user] Values ('Mehmood Sahb', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
--INSERT INTO student values (10,1010,2);

--INSERT INTO [user] Values ('Khizer ALi', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
--INSERT INTO student values (11,1011,2);

--INSERT INTO [user] Values ('Farooq ALi', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
--INSERT INTO student values (12,1012,2);

-------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO [user] Values ('Dr.Ibrahim', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
INSERT INTO teacher values (3);

INSERT INTO [user] Values ('Dr.Malik', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
INSERT INTO teacher values (4);

INSERT INTO [user] Values ('Hafeez', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
INSERT INTO admin values (5);

--INSERT INTO [user] Values ('Amir Raheem', '2313491849194','12345','Muhammad Ahmad',getdate(),'M', '03216961456','Okara')
--INSERT INTO teacher values (16);

--INSERT INTO [user] Values ('Abeeda Akram', '2313491849194','12345','Muhammad Ahmad',getdate(),'F', '03216961456','Okara')
--INSERT INTO teacher values (17);

select * from [user]


-----------------------------------------------------------------------------------------------------------------------------------------
Select*from course
INSERT INTO course Values ('PF',1,3)
INSERT INTO course Values ('ICT',1,3)
INSERT INTO course Values ('OOP',2,3)
INSERT INTO course Values ('CAL-II',2,3)
INSERT INTO course Values ('DS',3,3)
INSERT INTO course Values ('CPS',3,3)
INSERT INTO course Values ('DB',4,3)
INSERT INTO course Values ('COAL',4,3)




-------------------------------------------------------------------------------------------------------------------------------------------

select *from section
INSERT INTO Section Values ('A')
INSERT INTO Section Values ('B')


-------------------------------------------------------------------------------------------------------------------------------------------

select *from sem
INSERT INTO sem Values ('Fall-2019')
INSERT INTO sem Values ('Spring-2019')

-------------------------------------------------------------------------------------------------------------------------------------------
Select*from course_sec
--1
INSERT INTO course_sec Values (1,1,1,0)
INSERT INTO course_sec Values (1,2,1,0)

--3
INSERT INTO course_sec Values (2,1,1,0)
INSERT INTO course_sec Values (2,2,1,0)

--7
INSERT INTO course_sec Values (3,1,2,0)
INSERT INTO course_sec Values (3,2,2,0)

--3
INSERT INTO course_sec Values (4,1,2,0)
INSERT INTO course_sec Values (4,2,2,0)

--1
INSERT INTO course_sec Values (1,1,2,0)
INSERT INTO course_sec Values (1,2,2,0)

--3
INSERT INTO course_sec Values (2,1,2,0)
INSERT INTO course_sec Values (2,2,2,0)

---------------------------------------------------------------------------------------------------------------------------------------------
Select*from t_reg
insert into t_reg values (3,1,1)
insert into t_reg values (3,1,2)

insert into t_reg values (4,1,3)
insert into t_reg values (4,1,4)

insert into t_reg values (3,2,7)
insert into t_reg values (3,2,8)

insert into t_reg values (4,2,9)
insert into t_reg values (4,2,10)

insert into t_reg values (9,2,9)
insert into t_reg values (9,2,10)

insert into t_reg values (10,2,11)
insert into t_reg values (10,2,12)



----------------------------------------------------------------------------------------------------------------------------------------------
Select*from std_reg
insert into std_reg values (1,1,1,1,'A',4.00)
insert into std_reg values (1,1,3,1,'B',3.00)

insert into std_reg values (1,2,1,1,'B',3.00)
insert into std_reg values (1,2,3,1,'C',2.00)

insert into std_reg values (1,3,2,1,'A',4.00)
insert into std_reg values (1,3,4,1,'D',1.00)

insert into std_reg values (1,4,2,1,'A',4.00)
insert into std_reg values (1,4,4,1,'C',2.00)

----------------------------------------------------------------------------------------------------------------------------------------------
Select*from std_reg
Select*from student
Select*from course_sec
