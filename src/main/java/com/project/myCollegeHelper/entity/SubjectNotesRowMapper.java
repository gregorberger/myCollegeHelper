package com.project.myCollegeHelper.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectNotesRowMapper implements RowMapper<SubjectNotesEntity> {
    @Override
    public SubjectNotesEntity mapRow(ResultSet rs, int i) throws SQLException {
        SubjectNotesEntity subjectNotesEntity = new SubjectNotesEntity();
        subjectNotesEntity.setId(rs.getInt("id"));
        subjectNotesEntity.setTitle(rs.getString("title"));
        subjectNotesEntity.setSubjectId(rs.getInt("subjectID"));
        subjectNotesEntity.setStudentId(rs.getInt("studentID"));
        subjectNotesEntity.setNotes(rs.getString("notes"));

        return subjectNotesEntity;
    }
}
