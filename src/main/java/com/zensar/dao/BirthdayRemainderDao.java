package com.zensar.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.zensar.beans.Birthday;  
  
public class BirthdayRemainderDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Birthday p){  
    String sql="insert into Birthday(username,birthdate) values('"+p.getUsername()+"''"+p.getBirthdate()+"')";  
    return template.update(sql);  
}  

public Birthday getUserName(String username){  
    String sql="select * from Birthday where username=?";  
    return template.queryForObject(sql, new Object[]{username},new BeanPropertyRowMapper<Birthday>(Birthday.class));  
}  

  
}  