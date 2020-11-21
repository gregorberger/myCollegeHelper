create database if not exists Data;

use Data;

CREATE TABLE if not exists Data.user_info (
        id INT NOT NULL AUTO_INCREMENT,
        first_name VARCHAR(100),
        last_name VARCHAR(100),
        email VARCHAR(150),
        insert_date DATE,
        session_id VARCHAR(500),
        primary key (id)
);

DROP TABLE IF EXISTS Data.students;
CREATE TABLE Data.students(
          sid  int  not null AUTO_INCREMENT,
          name text not null,
          last_name text not null,
          email text not null,
          primary key(sid)
);


DROP TABLE IF EXISTS Data.subjects;
CREATE TABLE Data.subjects(
          subid int  not null AUTO_INCREMENT,
          name  text not null,
          primary key(subid)
);


DROP TABLE IF EXISTS Data.grades;
CREATE TABLE Data.grades(
        studentID int not null references students(sid),
        subjectID int not null references subjects(subid),
        grade varchar(20),
        primary key(studentID, subjectID)
);


DROP TABLE IF EXISTS Data.subject_notes;
CREATE TABLE Data.subject_notes(
           id int not null AUTO_INCREMENT,
           studentID int not null references students(sid),
           subjectID int not null references subjects(subid),
           title text(50),
           notes text(10000),
           primary key(id, studentID, subjectID)
);