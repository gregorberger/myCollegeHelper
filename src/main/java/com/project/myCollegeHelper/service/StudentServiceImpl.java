package com.project.myCollegeHelper.service;

import com.project.myCollegeHelper.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;

@Service
public class StudentServiceImpl extends JdbcDaoSupport implements StudentService {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }


    @Override
    public void insertStudent(StudentsEntity student) {
        String sql = "select count(*) from students where email like '"+ student.getEmail() +"'";
        Integer rows = getJdbcTemplate().queryForObject(sql, Integer.class);
        // ce student ne obstaja ga dodda v tabelo
        if(rows != null && rows == 0) {
            sql = "INSERT INTO students " + "(name, last_name, email) VALUES (?, ?, ?)";
            getJdbcTemplate().update(sql, student.getName(), student.getLastName(), student.getEmail());
        }
    }

    @Override
    public StudentsEntity getStudentByEmail(String email) {
        String sql = "select * from students where email = ?";
        return (StudentsEntity) getJdbcTemplate().queryForObject(sql,new Object[]{email},
                new StudentRowMapper());
    }

    @Override
    public void insertSubjectNote(SubjectNotesEntity note) {
        String sql = "select count(*) from subject_notes where title like '"+ note.getTitle() +"'";
        Integer rows = getJdbcTemplate().queryForObject(sql, Integer.class);
        // ce note iz titlom obstaja samo updejta notes text
        if(rows != null && rows != 0) {
            sql = "UPDATE subject_notes SET notes = '" + note.getNotes() + "' WHERE title = '"+ note.getTitle() +"';";
            getJdbcTemplate().execute(sql);
        } else {
            sql = "INSERT INTO subject_notes " + "(studentID, subjectID, title, notes) VALUES (?, ?, ?,?)";
            getJdbcTemplate().update(sql, note.getStudentId(), note.getSubjectId(), note.getTitle(), note.getNotes());
        }

    }

    @Override
    public ArrayList<SubjectNotesEntity> getNotes(String studentId, String subjectId) {
        String sql = "select * from subject_notes where studentID = ? and  subjectID = ?";
        return (ArrayList<SubjectNotesEntity>) getJdbcTemplate().query(sql,new Object[]{studentId, subjectId},
                new SubjectNotesRowMapper());
    }

    @Override
    public SubjectNotesEntity getNote(String noteId) {
        String sql = "select * from subject_notes where id = ?";
        return (SubjectNotesEntity) getJdbcTemplate().queryForObject(sql,new Object[]{noteId},
                new SubjectNotesRowMapper());
    }

    @Override
    public void insertSubject(SubjectsEntity subject) {
        String sql = "select count(*) from subjects where name like '"+ subject.getName() +"'";
        Integer rows = getJdbcTemplate().queryForObject(sql, Integer.class);
        // ce ta predmet se ne obstaja ga dodda v tabelo
        if(rows != null && rows == 0) {
            sql = "INSERT INTO subjects " + "(name) VALUES (?)";
            getJdbcTemplate().update(sql, subject.getName());
        }
    }

    @Override
    public SubjectsEntity getSubject(String subjectName) {
        String sql = "select * from subjects where name = ?";
        return (SubjectsEntity) getJdbcTemplate().queryForObject(sql,new Object[]{subjectName},
                new SubjectsRowMapper());
    }

    @Override
    public void insertGrade(GradesEntity grades) {
        String sql = "select count(*) from grades where studentID = '"+ grades.getStudentId() + "' and subjectID = '"+ grades.getSubjectId() + "'";
        Integer rows = getJdbcTemplate().queryForObject(sql, Integer.class);
        if(rows != null && rows != 0) {
            sql = "UPDATE grades SET grade = '" + grades.getGrade() + "' WHERE studentID = '"+ grades.getStudentId() + "' and subjectID = '"+ grades.getSubjectId() + "'";
            getJdbcTemplate().execute(sql);
        } else {
            sql = "INSERT INTO grades " + "(studentID, subjectID, grade) VALUES (?, ?, ?)";
            getJdbcTemplate().update(sql, grades.getStudentId(), grades.getSubjectId(), grades.getGrade());
        }
    }

    @Override
    public GradesEntity getGrade(String studentId, String subjectId) {
        String sql = "select * from grades where studentID = ? and subjectID = ?";
        return (GradesEntity) getJdbcTemplate().queryForObject(sql,new Object[]{studentId, subjectId},
                new GradesRowMapper());
    }
}
