package com.project.myCollegeHelper.service;

import com.project.myCollegeHelper.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Service
public class UserServiceImpl extends JdbcDaoSupport implements UserService {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO user_info " + "(first_name, last_name, email, insert_date, session_id) VALUES (?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[] { user.getFirstName(), user.getLastName(), user.getEmail(), user.getInsertDate(), user.getSession_id() });
    }

    @Override
    public boolean userSessionExists(String sessionId) {
        String sql = "select count(*) from user_info where session_id like '"+ sessionId +"'";
        Integer rows = getJdbcTemplate().queryForObject(sql, Integer.class);
        return rows != null && rows > 0;

    }
}
