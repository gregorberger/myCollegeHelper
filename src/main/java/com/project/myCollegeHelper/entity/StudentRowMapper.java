package com.project.myCollegeHelper.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<StudentsEntity> {
    @Override
    public StudentsEntity mapRow(ResultSet rs, int i) throws SQLException {
        StudentsEntity studentsEntity = new StudentsEntity();
        studentsEntity.setSid(rs.getInt("sid"));
        studentsEntity.setEmail(rs.getString("email"));
        studentsEntity.setName(rs.getString("name"));
        studentsEntity.setLastName(rs.getString("last_name"));

        return studentsEntity;
    }
}
