CREATE DATABASE schooldb;
USE schooldb;
SELECT * FROM students;
SELECT * FROM course_materials;
SELECT * FROM course;
SELECT * FROM teacher;
TRUNCATE students;

ALTER table teacher
DROP column service_period;

ALTER table course
DROP column teacher_id;

ALTER table course
DROP constraint FKsybhlxoejr4j3teomm5u2bx1n;

