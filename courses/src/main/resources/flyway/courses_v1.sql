drop table if exists students_courses;
drop table if exists courses;
drop table if exists students;

create table students (
student_id INT auto_increment not null,
first_name varchar(32) not null,
last_name varchar(32) not null,
primary key (student_id)
);

create table courses (
course_id INT auto_increment not null,
student_id INT not null,
title varchar(128) not null,
primary key (course_id),
foreign key (student_id) references students (student_id) on delete cascade
);

create table students_courses (
student_id INT auto_increment not null,
course_id INT not null,
foreign key (student_id) references students (student_id) on delete cascade,
foreign key (course_id) references courses (course_id) on delete cascade
);