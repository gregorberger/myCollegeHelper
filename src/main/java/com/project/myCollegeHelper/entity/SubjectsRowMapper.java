package com.project.myCollegeHelper.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectsRowMapper implements RowMapper<SubjectsEntity> {
    @Override
    public SubjectsEntity mapRow(ResultSet rs, int i) throws SQLException {
        SubjectsEntity subjectsEntity = new SubjectsEntity();
        subjectsEntity.setSubid(rs.getInt("subid"));
        subjectsEntity.setName(rs.getString("name"));

        return subjectsEntity;
    }
}
