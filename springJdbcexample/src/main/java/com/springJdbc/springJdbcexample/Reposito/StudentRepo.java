package com.springJdbc.springJdbcexample.Reposito;

import com.springJdbc.springJdbcexample.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String query = "insert into student (rollNo, name, marks) values (?,?,?)";
        int row = jdbc.update(query,s.getRollNo(),s.getName(),s.getMarks());
        System.out.println(row+"Affected.");
    }

    public List<Student> findAll() {
       String query = "select * from student";
        RowMapper mapper= ( rs, rowNum)-> {
                Student s=new Student();
                s.setRollNo(rs.getInt("RollNo"));
                s.setName(rs.getString("Name"));
                s.setMarks(rs.getInt("Marks"));
                return s;
            };
        return jdbc.query(query,mapper);
    }
}
