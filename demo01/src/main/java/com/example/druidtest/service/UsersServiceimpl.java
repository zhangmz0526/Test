package com.example.druidtest.service;


import com.example.druidtest.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Map;

@Service
public class UsersServiceimpl implements UsersService{
    private final JdbcTemplate jdbcTemplate;

    public UsersServiceimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> getUser(Integer id) {
        String sql="select * from table_test where id=?";
        return jdbcTemplate.queryForList(sql,id);
    }

    @Override
    public List<Map<String, Object>> getUserList() {
        String sql="select * from table_test";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public String postUser(User user) {
        String sql="insert into table_test values (?,?,?,?,?,?)";
        Object[] data ={user.getId(),user.getName(),user.getLevel(),user.getCreate_time(),user.getDelete_flag(),user.getExtension()};
        jdbcTemplate.update(sql,data);
        return "add-ok";
    }

    @Override
    public String putUser(Integer id, User user) {
        String sql="update table_test set name=?, level=? ,create_time=?, delete_flag=?, extension=? where id="+id;
        Object[] data2={user.getName(),user.getLevel(),user.getCreate_time(),user.getDelete_flag(),user.getExtension()};
        jdbcTemplate.update(sql,data2);
        return "update-ok";
    }

    @Override
    public String deleteUser(Integer id) {
        String sql="delete from table_test where id=?";
        jdbcTemplate.update(sql,id);
        return "delete-ok";
    }
}