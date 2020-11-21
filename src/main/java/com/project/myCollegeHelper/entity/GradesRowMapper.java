package com.project.myCollegeHelper.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GradesRowMapper implements RowMapper<GradesEntity> {
    @Override
    public GradesEntity mapRow(ResultSet rs, int i) throws SQLException {
        GradesEntity gradesEntity = new GradesEntity();
        gradesEntity.setSubjectId(rs.getInt("subjectID"));
        gradesEntity.setStudentId(rs.getInt("studentID"));
        gradesEntity.setGrade(rs.getString("grade"));

        return gradesEntity;
    }
}
